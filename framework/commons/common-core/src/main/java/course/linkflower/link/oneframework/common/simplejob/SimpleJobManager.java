package course.linkflower.link.oneframework.common.simplejob;

import course.linkflower.link.oneframework.common.simplejob.annotation.Worker;
import course.linkflower.link.oneframework.common.simplejob.model.Job;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Component("simpleJobManager")
@Slf4j
public class SimpleJobManager {

    public final static int JobArrayCount = 1000;
    private final Map<String, Boolean> singletonMap = new HashMap<>();

    public static String getWorkerNameByClass(Class cls) {
        return cls.getSimpleName();
    }

    private final List<Job> jobLists = new ArrayList<>();

    private final List<Thread> threads = new ArrayList<>();
    @Data
    protected static class  JobMethodInfo {
        private Object jobWorker;
        private Method m;
    }
    private final Map<String, List<JobMethodInfo>> jobWorker = new HashMap<>();

    private int startPos = 0;
    private int endPos = 0;
    private boolean isPosLoop = false;

    private final Runnable jobRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    Job job = null;
                    synchronized (jobLists) {
                        if (jobLists.size() > 0) {
                            if ((startPos != endPos) || !isPosLoop) {
                                job = jobLists.get(startPos);
                                if (startPos == endPos) {
                                    isPosLoop = true;
                                } else {
                                    startPos++;
                                    if (startPos >= jobLists.size()) {
                                        startPos = 0;
                                    }
                                }
                            }
                        }
                    }
                    if (job != null) {
                        if (job.isSingleton()) {
                            synchronized (singletonMap) {
                                if (singletonMap.get(job.getName()) != null) {
                                    return;
                                }
                                singletonMap.put(job.getName(), true);
                            }
                        }

                        List<JobMethodInfo> list = jobWorker.get(job.getName());
                        if (list != null) {
                            for (JobMethodInfo l : list) {
                                try {
                                    l.getM().invoke(l.getJobWorker(), job.getObj());
                                } catch (Exception e) {
                                    log.error("jobThreadHandle", e);
                                }
                            }
                        }

                        if (job.isSingleton()) {
                            synchronized (singletonMap) {
                                singletonMap.remove(job.getName());
                            }
                        }
                    } else {
                        synchronized (jobLists) {
                            try {
                                jobLists.wait();
                            } catch (Exception e) {
                                log.error("SimpleJobManager", e);
                                try {
                                    Thread.sleep(100);
                                } catch (Exception e1) {
                                    log.error("SimpleJobManager1", e1);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                log.error("SimpleJobManager-jobRunnable", e);
            }
        }
    };
    @Autowired
    ApplicationContext applicationContext;

    /*
    0
    startPos = 0
    endPos = 0

     */
    public void addJob(Job job) {
        synchronized (jobLists) {
            if (jobLists.size() >= JobArrayCount) {
                endPos++;
                if (endPos >= jobLists.size()) {
                    endPos = 0;
                }
                jobLists.get(endPos).loadFrom(job);
                if (startPos == endPos) {
                    startPos++;
                    if (startPos >= jobLists.size()) {
                        startPos = 0;
                    }
                }
                isPosLoop = false;
            } else {
                jobLists.add(job);
                endPos = jobLists.size() - 1;
            }
            jobLists.notify();
        }
    }

    public void startJobManager(int corePoolSize,
                                int maximumPoolSize,
                                long keepAliveTime) {

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            Object obj = applicationContext.getBean(beanName);
            Class<?> objClz = obj.getClass();
            if (org.springframework.aop.support.AopUtils.isAopProxy(obj)) {
                objClz = org.springframework.aop.support.AopUtils.getTargetClass(obj);
            }

            for (Method m : objClz.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Worker.class)) {
                    Worker worker = m.getAnnotation(Worker.class);
                    if (worker != null) {
                        String name = worker.name();
                        if (name == null || name.length() == 0) {
                            if (obj instanceof ISimpleJobBase) {
                                ISimpleJobBase jobBase = (ISimpleJobBase)obj;
                                name = jobBase.getName();
                            } else {
                                name = obj.getClass().getSimpleName();
                            }
                        }
                        if (name != null) {
                            JobMethodInfo info = new JobMethodInfo();
                            info.setJobWorker(obj);
                            info.setM(m);
                            List<JobMethodInfo> list = jobWorker.get(name);
                            if (list == null) {
                                list = new ArrayList<>();
                                jobWorker.put(name, list);
                            }

                            list.add(info);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < corePoolSize; i++) {
            Thread thread = new Thread(this.jobRunnable, "simpleJobManager-" + i);
            thread.start();
            threads.add(thread);
        }
    }
}
