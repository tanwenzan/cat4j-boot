package cn.zeroable.cat4j.web.config.filter.response.impl;

import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.web.config.filter.response.AbstractResponseFilter;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;

/**
 * Void 返回值过滤器.
 * <br/> 如果是void，如果能正常执行，则返回默认成功.
 *
 * @author zeroable
 * @version 2024/1/5 15:55
 * @since 0.0.1
 */
@Component
@Order(1)
public class VoidResponseFilter extends AbstractResponseFilter {

    @Override
    protected Object doFilter(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果是void，如果能正常执行，则返回默认成功.
        if (Void.class.equals(returnType.getParameterType())) {
            return ApiResult.ok();
        }
        return null;
    }
}
