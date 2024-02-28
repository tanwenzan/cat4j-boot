package cn.zeroable.cat4j.core.util;

import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 集合工具类.
 *
 * @author zeroable
 * @version 2023/8/28 15:32
 * @see org.springframework.util.Assert
 * @since 0.0.1
 */
public class CollectionUtil {

    public static <T, K> Map<K, List<T>> groupList(List<T> list, Function<T, K> keyFunction) {
        return groupList(list, (item) -> item, (item, val) -> keyFunction.apply(item));
    }

    public static <T, K, V> Map<K, List<V>> groupList(List<T> list, Function<T, V> convert, BiFunction<T, V, K> keyFunction) {
        if (ObjectUtil.isEmpty(list)) {
            return new HashMap<>();
        }
        Map<K, List<V>> result = new HashMap<>();
        for (T t : list) {
            V value = convert.apply(t);
            K key = keyFunction.apply(t, value);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(value);
        }
        return result;
    }
}
