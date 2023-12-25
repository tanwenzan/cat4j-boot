package cn.zeroable.cat4j.core.util;

import cn.zeroable.cat4j.core.exception.BiException;
import jakarta.annotation.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 断言工具类.
 * <br/> 基于spring Assert 封装
 *
 * @author zeroable
 * @version 2023/8/28 15:32
 * @see org.springframework.util.Assert
 * @since 0.0.1
 */
public class AssertUtil {

    /**
     * 断言布尔表达式，如果表达式计算结果为 false，则抛出 {@code BiException}。
     * <br/> {@code AssertUtil.isTrue(i > 0, "The value must be greater than zero");}
     *
     * @param expression 一个 boolean 表达式
     * @param message    断言失败时使用的异常消息
     * @throws BiException 当 expression 为false时抛出
     * @author zeroable
     * @date 2023/8/28 15:36
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BiException(message);
        }
    }

    /**
     * 断言布尔表达式，如果表达式计算结果为 false，则抛出 BiException。
     * <pre class="code">
     * Assert.isTrue(i &gt; 0, () -&gt; "The value '" + i + "' must be greater than zero");
     * </pre>
     *
     * @param expression      一个 boolean 表达式
     * @param messageSupplier 断言失败时使用的异常消息的提供者
     * @throws BiException 当 expression 为false时抛出
     * @author zeroable
     * @date 2023/8/28 15:41
     */
    public static void isTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new BiException(nullSafeGet(messageSupplier));
        }
    }

    /**
     * 断言布尔表达式，如果表达式计算结果为 false，则抛出 {@code BiException}。
     * <br/> {@code AssertUtil.isTrue(i < 0, "The value must be greater than zero");}
     *
     * @param expression 一个 boolean 表达式
     * @param message    断言失败时使用的异常消息
     * @throws BiException 当 expression 为true时抛出
     * @author zeroable
     * @date 2023/10/23 9:51
     */
    public static void isFalse(boolean expression, String message) {
        isTrue(!expression, message);
    }

    /**
     * 断言布尔表达式，如果表达式计算结果为 true，则抛出 BiException。
     * <pre class="code">
     * Assert.isFalse(i &lt; 0, () -&gt; "The value '" + i + "' must be greater than zero");
     * </pre>
     *
     * @param expression      一个 boolean 表达式
     * @param messageSupplier 断言失败时使用的异常消息的提供者
     * @throws BiException 当 expression 为true时抛出
     * @author zeroable
     * @date 2023/10/23 9:51
     */
    public static void isFalse(boolean expression, Supplier<String> messageSupplier) {
        isTrue(!expression, messageSupplier);
    }

    /**
     * 断言一个对象为空。
     * <pre class="code">Assert.isNull(value, "The value must be null");</pre>
     *
     * @param object  对象
     * @param message 断言失败时使用的异常消息
     * @throws BiException 当 expression 为false时抛出
     * @author zeroable
     * @date 2023/8/28 15:43
     */
    public static void isNull(@Nullable Object object, String message) {
        isTrue(object == null, message);
    }

    /**
     * 断言一个对象不为空。
     * <pre class="code">Assert.notNull(value, "The value can not be null");</pre>
     *
     * @param object  对象
     * @param message 断言失败时使用的异常消息
     * @throws BiException 当 expression 为false时抛出
     * @author zeroable
     * @date 2023/8/28 15:49
     */
    public static void notNull(@Nullable Object object, String message) {
        isTrue(object != null, message);
    }

    /**
     * 断言一个字符串有长度。
     *
     * @param text    字符串
     * @param message 断言失败时使用的异常消息
     * @throws BiException 当字符串变量为null 或者为空字符时抛出
     * @author zeroable
     * @date 2023/8/28 15:49
     */
    public static void hasLength(@Nullable String text, String message) {
        isTrue(StringUtils.hasLength(text), message);
    }

    /**
     * 断言一个字符串有字符。
     *
     * @param text    字符串
     * @param message 断言失败时使用的异常消息
     * @throws BiException 当字符串变量为null 或者为空字符时抛出
     * @author zeroable
     * @date 2023/8/28 15:49
     */
    public static void hasText(@Nullable String text, String message) {
        isTrue(StringUtils.hasText(text), message);
    }

    /**
     * 断言一个对象数组不为空。
     *
     * @param array   数组
     * @param message 断言失败时使用的异常消息
     * @author zeroable
     * @throws BiException 当 对象数组 为空时抛出
     * @date 2023/8/28 15:49
     */
    public static void notEmpty(@Nullable Object[] array, String message) {
        isTrue(!ObjectUtils.isEmpty(array), message);
    }

    /**
     * 断言一个集合对象不为空。
     *
     * @param collection 集合对象
     * @param message    断言失败时使用的异常消息
     * @throws BiException 当集合对象为空时抛出
     * @author zeroable
     * @date 2023/8/28 15:49
     */
    public static void notEmpty(@Nullable Collection<?> collection, String message) {
        isTrue(!CollectionUtils.isEmpty(collection), message);
    }

    /**
     * 断言一个map对象不为空。
     *
     * @param map     map对象
     * @param message 断言失败时使用的异常消息
     * @throws BiException 当map对象为空时抛出
     * @author zeroable
     * @date 2023/8/28 15:48
     */
    public static void notEmpty(@Nullable Map<?, ?> map, String message) {
        isTrue(!CollectionUtils.isEmpty(map), message);
    }


    @Nullable
    private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
        return (messageSupplier != null ? messageSupplier.get() : null);
    }
}
