package course.linkflower.link.oneframework.common.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 锁对象抽象
 *
 * @author xxx
 * @date 2020/7/28
 * <p>
 * Blog: https://e2cef2000.gitee.io
 * Github: https://github.com/e2cef2000
 */
@AllArgsConstructor
public class ZLock implements AutoCloseable {
    @Getter
    private final Object lock;

    private final DistributedLock locker;

    @Override
    public void close() throws Exception {
        locker.unlock(lock);
    }
}
