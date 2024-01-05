package cn.zeroable.cat4j.core.util;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 2023/8/18 10:23
 * @see
 * @since 0.0.1
 */
public class NumberUtil {


    /**
     * 将 String 转换为 int，如果转换失败则返回零。
     *
     * @param value 要转换的字符串，可以为空
     * @return int 字符串表示的 int，如果转换失败则为 0
     * @author zeroable
     * @date 2023/8/18 10:25
     */

    public static int toInt(final Object value) {
        return NumberUtil.toInt(String.valueOf(value));
    }

    public static int toInt(final Object value, final int defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(String.valueOf(value));
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static long toLong(final Object value) {
        return NumberUtil.toLong(String.valueOf(value));
    }

    public static long toLong(final Object value, final long defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(String.valueOf(value));
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static Double toDouble(Object value) {
        return toDouble(String.valueOf(value), -1.00);
    }

    public static Double toDouble(Object value, Double defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(String.valueOf(value));
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static Float toFloat(Object value) {
        return toFloat(String.valueOf(value), -1.0f);
    }

    public static Float toFloat(Object value, Float defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(String.valueOf(value));
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }
}
