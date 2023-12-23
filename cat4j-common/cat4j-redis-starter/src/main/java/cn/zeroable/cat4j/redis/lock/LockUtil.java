package cn.zeroable.cat4j.redis.lock;

import lombok.AllArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * LockUtil 分布式锁工具.
 *
 * @author tanwenzan
 * @version 2023/12/23 11:31
 * @see RedissonClient
 * @since 0.0.1
 */
@Component
@AllArgsConstructor
public class LockUtil {

    private RedissonClient redissonClient;

    /**
     * 无参同步执行。
     *
     * @param key      独占key
     * @param operator 操作
     * @author tanwenzan
     * @date 2023/12/23 11:43
     */
    public void lock(String key, Operator operator) {
        lock(key, () -> {
            operator.operator();
            return true;
        });
    }


    public <T> T lock(String key, Supplier<T> supplier) {
        RLock lock = redissonClient.getLock(key);
        try {
            lock.lock();
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }

    public boolean tryLock(String key) {
        RLock lock = redissonClient.getLock(key);
        return lock.tryLock();
    }
}
