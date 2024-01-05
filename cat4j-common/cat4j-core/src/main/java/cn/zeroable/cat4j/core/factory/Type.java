package cn.zeroable.cat4j.core.factory;

/**
 * 类型接口.
 * <br/> 此接口作用于同一场景下不同处理方式的区别.如在数据源场景下，可能会有很多种数据源类型，
 *
 * @author zeroable
 * @version 2023/8/18 16:49
 * @since 0.0.1
 */
public interface Type<T> {

    /**
     * 类型。
     * <br/>返回该类型的标识，同场景下，返回值必须唯一。
     *
     * @return T 返回类型
     * @author zeroable
     * @date 2023/8/18 16:54
     */
    T getType();
}
