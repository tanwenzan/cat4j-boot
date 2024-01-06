package cn.zeroable.cat4j.web.config.handler;


import cn.hutool.core.util.StrUtil;
import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.core.exception.BiException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import jakarta.validation.ConstraintViolation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * 全局异常处理.
 *
 * @author zeroable
 * @version 1/6/24 12:08 AM
 * @see
 * @since 0.0.1
 */
@RestControllerAdvice
@Slf4j
public class BiExceptionHandler {
    /**
     * 参数校验失败抛出的异常。
     *
     * @param e 错误信息
     * @return cn.zeroable.cat4j.core.ApiResult<java.lang.String>
     * @author tanwenzan
     * @date 2023/8/23 14:12
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            // 绑定异常
            BindException.class,
            // 参数无效异常
            MethodArgumentNotValidException.class
    })
    public ApiResult<String> bindExceptionHandler(BindException e) {
        log.error("Validation格式校验异常", e);
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> msgList = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        String messages = StringUtils.join(msgList, ';');
        log.error("Validation格式校验异常:-------------->{}", messages);
        return ApiResult.fail(HttpStatus.BAD_REQUEST.value(), messages);
    }

    /**
     * 参数校验失败抛出的异常。
     * <br/> 违反约束异常
     *
     * @param e 异常信息
     * @return cn.zeroable.cat4j.core.ApiResult<java.lang.String>
     * @author tanwenzan
     * @date 2023/8/8 15:32
     */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult<String> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("违反约束异常", e);
        Object[] messagesArr = Optional.ofNullable(e.getConstraintViolations()).orElse(new HashSet<>())
                .stream().map(ConstraintViolation::getMessage).toArray(String[]::new);
        String msg = StrUtil.join(";", messagesArr);
        log.error("违反约束异常:-------------->{}", msg);
        return ApiResult.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    /**
     * 业务异常。
     *
     * @param e 异常信息
     * @return cn.zeroable.cat4j.core.ApiResult<java.lang.Object>
     * @author tanwenzan
     * @date 2023/8/8 15:32
     */
    @ExceptionHandler(BiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult<String> biException(BiException e) {
        log.error("业务异常", e);
        return ApiResult.fail(e.getMessage());
    }

    /**
     * 系统异常 预期以外异常
     *
     * @param e 异常信息
     * @return cn.zeroable.cat4j.core.ApiResult<java.lang.Object>
     * @author tanwenzan
     * @date 2023/8/8 15:31
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<String> exceptionHandler(Exception e) {
        log.error("未知异常！", e);
        return ApiResult.fail("服务器出错了，请联系管理员处理");
    }

    /**
     * 所有异常地拦截。
     *
     * @param e 异常信息
     * @return cn.zeroable.cat4j.core.ApiResult<java.lang.Object>
     * @author tanwenzan
     * @date 2023/8/8 15:31
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<String> throwableHandler(Throwable e) {
        log.error("未知异常！", e);
        return ApiResult.fail("服务器出错了，请联系管理员处理");
    }
}
