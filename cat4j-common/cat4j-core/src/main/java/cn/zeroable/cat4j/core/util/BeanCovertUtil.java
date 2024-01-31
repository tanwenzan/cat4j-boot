package cn.zeroable.cat4j.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.function.Consumer;

/**
 * bean 转换工具类.
 *
 * @author zeroable
 * @version 1/13/24 9:36 PM
 * @since 0.0.1
 */
@Slf4j
public class BeanCovertUtil {

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        return copyProperties(source, targetClass, null);
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass, Consumer<T> consumer) {
        AssertUtil.notNull(source, "对象转换失败：源对象为空");
        T target = null;
        try {
            target = targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("copyProperties errors:", e);
            throw new RuntimeException("对象转换失败：", e);
        }
        BeanUtils.copyProperties(source, target);
        if (consumer != null) {
            consumer.accept(target);
        }
        return target;
    }
}
