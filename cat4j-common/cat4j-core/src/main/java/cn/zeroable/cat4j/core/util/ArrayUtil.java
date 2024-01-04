package cn.zeroable.cat4j.core.util;

import java.util.Optional;

/**
 * 数组工具类.
 * <br/> 封装常用的数组工具类.
 *
 * @author tanwenzan
 * @version 2023/8/18 10:34
 * @since 0.0.1
 */
public class ArrayUtil {
    private static final String DEFAULT_SPLIT = ",";

    /**
     * 字符串转数组。
     * <br/>使用指定的分隔符 对字符串进行分割成数组。
     *
     * @param str   字符串
     * @param split 分割字符
     * @return java.lang.String[] 根据指定的分隔符分割的字符串数组
     * @author tanwenzan
     * @date 2023/8/18 11:03
     */
    public static String[] toStrArray(String str, String split) {
        return Optional.ofNullable(str).orElse("").split(split);
    }

    /**
     * 字符串转数组。
     * <br/>使用默认的,分隔符 对字符串进行分割成数组。
     *
     * @param str 字符串
     * @return java.lang.String[] 根据英文逗号分割的字符串数组
     * @author tanwenzan
     * @date 2023/8/18 11:01
     */
    public static String[] toStrArray(String str) {
        return toStrArray(str, DEFAULT_SPLIT);
    }
}
