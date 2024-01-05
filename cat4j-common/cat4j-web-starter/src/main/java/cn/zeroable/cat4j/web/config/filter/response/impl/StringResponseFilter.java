package cn.zeroable.cat4j.web.config.filter.response.impl;

import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.web.config.filter.response.AbstractResponseFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;

/**
 * String 返回类型处理.
 *
 * @author zeroable
 * @version 2024/1/5 15:52
 * @since 0.0.1
 */

@Component
@AllArgsConstructor
@Order(2)
@Slf4j
public class StringResponseFilter extends AbstractResponseFilter {

    private ObjectMapper objectMapper;

    @Override
    protected Object doFilter(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            try {
                return objectMapper.writeValueAsString(ApiResult.ok(body));
            } catch (JsonProcessingException e) {
                log.error("StringResponseFilter error:", e);
            }
        }
        return null;
    }
}
