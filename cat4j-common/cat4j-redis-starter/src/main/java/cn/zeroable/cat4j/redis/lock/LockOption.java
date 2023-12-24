package cn.zeroable.cat4j.redis.lock;

import cn.zeroable.cat4j.core.util.AssertUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 锁选项.
 * <br/> 根据锁选项进行加锁与操作.
 *
 * @author tanwenzan
 * @version 12/23/23 5:30 PM
 * @see LockUtil
 * @see org.redisson.api.RLock
 * @since 0.0.1
 */
public class LockOption {

    private List<String> keys;

    private Long leaseTime;

    private TimeUnit timeUnit;


    /**
     * 默认等待时间：0
     */
    private static final Long DEFAULT_LEASE_TIME = -1L;

    /**
     * 默认时间单位：null
     */
    private static final TimeUnit DEFAULT_TIME_UNIT = null;

    private LockOption(String key) {
        AssertUtil.hasText(key, "构建锁失败：key为空");
        this.keys = new ArrayList<>();
        keys.add(key);
        setDefaultLeaseTime();
    }

    private LockOption(String... keys) {
        AssertUtil.notEmpty(keys, "构建锁失败：keys为空");
        this.keys = new ArrayList<>(keys.length);
        for (String key : keys) {
            AssertUtil.hasText(key, "构建锁失败：key为空");
            this.keys.add(key);
        }
        setDefaultLeaseTime();
    }

    /**
     * 设置默认租期。
     *
     * @author tanwenzan
     * @date 12/23/23 6:24 PM
     */
    private void setDefaultLeaseTime() {
        this.leaseTime = DEFAULT_LEASE_TIME;
        this.timeUnit = DEFAULT_TIME_UNIT;
    }

    /**
     * 通过 key 构建 {@code LockOptions}。
     *
     * @param key key
     * @return cn.zeroable.cat4j.redis.lock.LockOptions
     * @author tanwenzan
     * @date 12/23/23 6:25 PM
     */
    public static LockOption byKey(String key) {
        return new LockOption(key);
    }

    /**
     * 通过组合keys 构建 {@code LockOptions}。
     *
     * @param keys 组合 key
     * @return cn.zeroable.cat4j.redis.lock.LockOptions
     * @author tanwenzan
     * @date 12/23/23 6:26 PM
     */
    public static LockOption byKeys(String... keys) {
        return new LockOption(keys);
    }

    /**
     * 添加 key 。
     *
     * @param key key
     * @return cn.zeroable.cat4j.redis.lock.LockOptions
     * @author tanwenzan
     * @date 12/23/23 6:27 PM
     */
    public LockOption addKey(String key) {
        AssertUtil.hasText(key, "添加key失败：key为空");
        this.keys.add(key);
        return this;
    }

    /**
     * 添加组合key。
     *
     * @param keys 组合key
     * @return cn.zeroable.cat4j.redis.lock.LockOptions
     * @author tanwenzan
     * @date 12/23/23 6:28 PM
     */
    public LockOption addKeys(String... keys) {
        AssertUtil.notEmpty(keys, "添加key失败：key为空");
        for (String key : keys) {
            AssertUtil.hasText(key, "构建锁失败：key为空");
            this.keys.add(key);
        }
        return this;
    }

    /**
     * 设置租期。
     *
     * @param leaseTime 租期
     * @param timeUnit  时间单位
     * @return cn.zeroable.cat4j.redis.lock.LockOptions
     * @author tanwenzan
     * @date 12/23/23 6:28 PM
     */
    public LockOption setLeaseTime(Long leaseTime, TimeUnit timeUnit) {
        AssertUtil.notNull(leaseTime, "设置时间失败：leaseTime 为空");
        AssertUtil.notNull(timeUnit, "设置时间失败：timeUnit 为空");
        this.leaseTime = leaseTime < 0 ? -1L : leaseTime;
        this.timeUnit = leaseTime == -1L ? DEFAULT_TIME_UNIT : timeUnit;
        return this;
    }

    /**
     * 设置租期。
     * <br/> 默认时间单位为 {@link TimeUnit#MILLISECONDS 毫秒}
     *
     * @param leaseTime 租期
     * @return cn.zeroable.cat4j.redis.lock.LockOptions
     * @author tanwenzan
     * @date 12/23/23 6:30 PM
     */
    public LockOption setLeaseTime(Long leaseTime) {
        return setLeaseTime(leaseTime, TimeUnit.MILLISECONDS);
    }

    public List<String> getKeys() {
        return keys;
    }

    public Long getLeaseTime() {
        return leaseTime;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

}
