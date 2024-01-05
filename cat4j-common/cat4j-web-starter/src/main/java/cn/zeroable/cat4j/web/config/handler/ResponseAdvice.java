package cn.zeroable.cat4j.web.config.handler;

import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.web.config.filter.response.ResponseFilterManager;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局统一结果返回封装.
 *
 * @author zeroable
 * @version 2024/1/5 15:43
 * @see
 * @since 0.0.1
 */
@RestControllerAdvice
@AllArgsConstructor
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    ResponseFilterManager responseFilterManager;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果接口返回的类型本身就是ApiResult那就没有必要进行额外的操作，返回false。
        // 如果类上加了我们的自定义注解也没有必要进行额外的操作
        // 如果方法上加了我们的自定义注解也没有必要进行额外的操作
        return !(returnType.getParameterType().equals(ApiResult.class)
                || returnType.getDeclaringClass().isAnnotationPresent(NotResponseBody.class)
                || returnType.hasMethodAnnotation(NotResponseBody.class));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果返回值就是 ApiResult 就不需要做处理了
        if (body instanceof ApiResult<?>) {
            return body;
        }
        // 使用过滤器进行处理。
        Object result = responseFilterManager
                .filter(body, returnType, selectedContentType, selectedConverterType, request, response);
        if (result != null) {
            return result;
        }
        return ApiResult.ok(body);
    }
}
