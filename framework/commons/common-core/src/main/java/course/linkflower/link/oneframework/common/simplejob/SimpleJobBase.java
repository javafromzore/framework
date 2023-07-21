package course.linkflower.link.oneframework.common.simplejob;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class SimpleJobBase implements ISimpleJobBase {

    private static final long LogOutputTime = 10 * 1000;
    private long headCount;
    private long oldCount;
    private long heartTime;

    public String getName() {
        String className = this.getClass().getSimpleName();
        return className;
    }

    public void addLogHeart() {
        headCount++;
        long t = System.currentTimeMillis();
        if ((heartTime < (t - LogOutputTime))) {
            log.info(String.format("存储运行10秒 %s: %d %d",  this.getClass().getSimpleName(), headCount, headCount - oldCount));
            heartTime = t;
            oldCount = headCount;
        }
    }
}
