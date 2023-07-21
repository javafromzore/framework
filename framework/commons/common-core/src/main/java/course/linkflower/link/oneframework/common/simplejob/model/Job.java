package course.linkflower.link.oneframework.common.simplejob.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Job {
    private String name;
    private Object obj;
    private boolean singleton;

    public Job(String name, Object obj) {
        this.name = name;
        this.obj = obj;
    }

    public Job loadFrom(Job job) {
        name = job.getName();
        obj = job.getObj();
        singleton = job.isSingleton();
        return this;
    }
}
