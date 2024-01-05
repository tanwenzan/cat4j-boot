package cn.zeroable.cat4j.web.config.filter.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

/**
 * ResponseFilter 的抽象类.
 * <br/> 封装一些常用方法.
 *
 * @author zeroable
 * @version 2024/1/5 15:50
 * @since 0.0.1
 */
public abstract class AbstractResponseFilter implements ResponseFilter {
    protected ResponseFilter nextFilter;

    /**
     * 真实过滤方法。
     * <br/> 交由子类去具体实现
     *
     * @param body                  原始返回数据
     * @param returnType            返回类型
     * @param selectedContentType   选中的内容类型
     * @param selectedConverterType 选择的转换类型
     * @param request               请求对象
     * @param response              响应体
     * @return java.lang.Object
     * @author zeroable
     * @date 2023/8/9 14:29
     */
    protected abstract Object doFilter(Object body, MethodParameter returnType, MediaType selectedContentType,
                                       Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                       ServerHttpRequest request, ServerHttpResponse response);

    @Override
    public void setNext(ResponseFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    @Override
    public final Object filter(Object body, MethodParameter returnType, MediaType selectedContentType,
                               Class<? extends HttpMessageConverter<?>> selectedConverterType,
                               ServerHttpRequest request, ServerHttpResponse response) {
        Object obj = doFilter(body, returnType, selectedContentType, selectedConverterType, request, response);
        if (null != nextFilter) {
            Object nextObj = nextFilter.filter(body, returnType, selectedContentType, selectedConverterType, request,
                    response);
            if (nextObj != null) {
                obj = nextObj;
            }
        }
        return obj;
    }
}
