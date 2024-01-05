package cn.zeroable.cat4j.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * api 结果返回集合.
 *
 * @author zeroable
 * @version 12/23/23 5:39 PM
 * @since 0.0.1
 */
@Getter
@Setter
@AllArgsConstructor
public class ApiResult<T> {
    private static final Integer DEFAULT_SUCCESS_CODE = 200;

    private static final Integer DEFAULT_ERROR_CODE = 500;

    /**
     * 编码，成功返回200，错误默认返回500
     *
     * @mock 200
     */
    private Integer code;

    /**
     * 返回结果，成功为true，反之为false
     *
     * @mock true
     */
    private Boolean success;

    /**
     * 数据集
     *
     * @mock {}
     */
    private T data;

    /**
     * 返回消息，如果返回错误时会携带一些信息
     *
     * @mock 操作成功
     */
    private String message;

    /**
     * 返回一个不带任何信息何数据的成功标志的对象。
     *
     * @return cn.zeroable.cat4j.core.ApiResult<T>
     * @author zeroable
     * @date 2023/8/8 14:45
     */
    public static <T> ApiResult<T> ok() {
        return new ApiResult<>(DEFAULT_SUCCESS_CODE, true, null, "");
    }

    /**
     * 返回一个指定状态码的成功标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param code 状态码
     * @return cn.zeroable.cat4j.core.ApiResult<T> 指定状态码
     * @author zeroable
     * @date 2023/8/8 14:46
     * @see ApiResult#ok() ApiResult#ok()
     */
    public static <T> ApiResult<T> ok(Integer code) {
        ApiResult<T> apiResult = ok();
        apiResult.setCode(code);
        return apiResult;
    }

    /**
     * 返回一个指定信息的成功标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param message 信息，一般是提示信息
     * @return cn.zeroable.cat4j.core.ApiResult<T> 指定message
     * @author zeroable
     * @date 2023/8/8 14:49
     */
    public static <T> ApiResult<T> ok(String message) {
        ApiResult<T> apiResult = ok();
        apiResult.setMessage(message);
        return apiResult;
    }

    /**
     * 返回一个指定数据的成功标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param data 数据
     * @return cn.zeroable.cat4j.core.ApiResult<T> 指定数据
     * @author zeroable
     * @date 2023/8/8 14:50
     */
    public static <T> ApiResult<T> ok(T data) {
        ApiResult<T> apiResult = ok();
        apiResult.setData(data);
        return apiResult;
    }

    /**
     * 返回一个指定数据与信息的成功标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param data    数据
     * @param message 信息
     * @return cn.zeroable.cat4j.core.ApiResult<T>
     * @author zeroable
     * @date 2023/8/8 14:51
     */
    public static <T> ApiResult<T> ok(T data, String message) {
        ApiResult<T> apiResult = ok(message);
        apiResult.setData(data);
        return apiResult;
    }

    /**
     * 返回一个指定状态码与数据的成功标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param code 状态码
     * @param data 数据
     * @return cn.zeroable.cat4j.core.ApiResult<T>
     * @author zeroable
     * @date 2023/8/8 14:51
     */

    public static <T> ApiResult<T> ok(Integer code, T data) {
        ApiResult<T> apiResult = ok(data);
        apiResult.setCode(code);
        return apiResult;
    }

    /**
     * 返回一个指定状态码与信息的成功标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param code    状态码
     * @param message 信息
     * @return cn.zeroable.cat4j.core.ApiResult<T>
     * @author zeroable
     * @date 2023/8/8 14:51
     */
    public static <T> ApiResult<T> ok(Integer code, String message) {
        ApiResult<T> apiResult = ok(code);
        apiResult.setMessage(message);
        return apiResult;
    }

    /**
     * 返回一个不带任何信息何数据的失败标志的对象。
     *
     * @return cn.zeroable.cat4j.core.ApiResult<T>
     * @author zeroable
     * @date 2023/8/8 14:52
     */
    public static <T> ApiResult<T> fail() {
        return new ApiResult<>(DEFAULT_ERROR_CODE, false, null, "fail");
    }

    /**
     * 返回一个指定状态码与指定信息的失败标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param message 信息
     * @return cn.zeroable.cat4j.core.ApiResult<T> 指定信息
     * @author zeroable
     * @date 2023/8/8 14:52
     */
    public static <T> ApiResult<T> fail(String message) {
        ApiResult<T> fail = fail();
        fail.setMessage(message);
        return fail;
    }

    /**
     * 返回一个指定状态码与指定信息的失败标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param code    状态码
     * @param message 信息
     * @return cn.zeroable.cat4j.core.ApiResult<T> 指定状态码与信息
     * @author zeroable
     * @date 2023/8/8 14:52
     */
    public static <T> ApiResult<T> fail(Integer code, String message) {
        ApiResult<T> fail = fail(message);
        fail.setCode(code);
        return fail;
    }

    /**
     * 返回一个指定数据与指定信息的失败标志的 {@link ApiResult ApiResult} 对象。
     *
     * @param data    数据
     * @param message 消息
     * @return cn.zeroable.cat4j.core.ApiResult<T> 指定数据与指定信息
     * @author zeroable
     * @date 2023/8/8 14:53
     */
    public static <T> ApiResult<T> fail(T data, String message) {
        ApiResult<T> fail = fail(message);
        fail.setData(data);
        return fail;
    }
}
