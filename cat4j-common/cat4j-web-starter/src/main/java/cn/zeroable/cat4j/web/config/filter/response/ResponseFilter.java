package cn.zeroable.cat4j.web.config.filter.response;

import cn.zeroable.cat4j.web.config.handler.ResponseAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

/**
 * 响应过滤器.
 *
 * @author zeroable
 * @version 2024/1/5 15:45
 * @see ResponseAdvice
 * @since 0.0.1
 */
public interface ResponseFilter {

    /**
     * 设置下一个节点。
     *
     * @param nextFilter 下一个节点
     * @author zeroable
     * @date 2024/1/4 14:12
     */
    void setNext(ResponseFilter nextFilter);

    /**
     * 过滤方法。
     *
     * @param body                  原始返回数据
     * @param returnType            返回类型
     * @param selectedContentType   选中的内容类型
     * @param selectedConverterType 选择的转换类型
     * @param request               请求对象
     * @param response              响应体
     * @return java.lang.Object 响应数据
     * @author zeroable
     * @date 2024/1/4
     */
    Object filter(Object body, MethodParameter returnType, MediaType selectedContentType,
                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                  ServerHttpResponse response);
}
