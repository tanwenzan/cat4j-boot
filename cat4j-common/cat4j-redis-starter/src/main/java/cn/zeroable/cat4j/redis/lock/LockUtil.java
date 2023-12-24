package cn.zeroable.cat4j.redis.lock;

import cn.zeroable.cat4j.core.ApiResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.List;
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
@Slf4j
public class LockUtil {

    private RedissonClient redissonClient;

    /**
     * 无参同步执行。
     *
     * @param lockOption 锁信息
     * @param operator   操作
     * @author tanwenzan
     * @date 2023/12/23 11:43
     */
    public void lock(LockOption lockOption, Operator operator) {
        lock(lockOption, () -> {
            operator.operator();
            return true;
        });
    }


    public <T> T lock(LockOption lockOption, Supplier<T> supplier) {
        RLock lock = getLock(lockOption);
        try {
            lock.lock(lockOption.getLeaseTime(), lockOption.getTimeUnit());
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }

    private RLock getLock(LockOption lockOption) {
        List<String> keys = lockOption.getKeys();
        RLock[] rLocks = new RLock[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            rLocks[i] = redissonClient.getLock(keys.get(i));
        }
        return redissonClient.getMultiLock(rLocks);
    }

    public boolean tryLock(LockOption lockOption, Operator operator) {
        ApiResult<Boolean> result = tryLock(lockOption, () -> {
            operator.operator();
            return true;
        });
        return result.getSuccess();
    }

    public <T> ApiResult<T> tryLock(LockOption lockOption, Supplier<T> supplier) {
        RLock lock = getLock(lockOption);
        try {
            if (lock.tryLock(lockOption.getLeaseTime(), lockOption.getTimeUnit())) {
                try {
                    return ApiResult.ok(supplier.get());
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return ApiResult.fail();
    }

}
