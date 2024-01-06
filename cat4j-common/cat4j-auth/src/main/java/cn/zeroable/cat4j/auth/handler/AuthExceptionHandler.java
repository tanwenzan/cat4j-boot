package cn.zeroable.cat4j.auth.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.zeroable.cat4j.core.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 鉴权异常处理器.
 *
 * @author zeroable
 * @version 1/6/24 10:12 AM
 * @since 0.0.1
 */
@RestControllerAdvice
@Slf4j
@Order(1)
public class AuthExceptionHandler {

    /**
     * 无权限。
     *
     * @param e 异常信息
     * @return cn.zeroable.cat4j.core.ApiResult<java.lang.Object>
     * @author tanwenzan
     * @date 1/6/24 12:15 AM
     */
    @ExceptionHandler(NotPermissionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResult<String> notPermissionException(NotPermissionException e) {
        return ApiResult.fail(HttpStatus.FORBIDDEN.value(), "您无权限执行次操作");
    }

    /**
     * 未登录。
     *
     * @param e 异常信息
     * @return cn.zeroable.cat4j.core.ApiResult<java.lang.Object>
     * @author tanwenzan
     * @date 1/6/24 12:15 AM
     */
    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResult<String> notLoginException(NotLoginException e) {
        return ApiResult.fail(HttpStatus.UNAUTHORIZED.value(), "未登录");
    }
}
