package cn.zeroable.cat4j.web.config.filter.response;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 统一响应过滤 器管理器.
 *
 * @author zeroable
 * @version 2024/1/5 15:45
 * @see ResponseFilter responseFilter
 * @since 0.0.1
 */
@Component
public class ResponseFilterManager {
    private ResponseFilter filter;

    public ResponseFilterManager(List<ResponseFilter> filterList) {
        // 如果过滤器不为空
        if (ObjectUtil.isNotEmpty(filterList)) {
            filterList.sort(AnnotationAwareOrderComparator.INSTANCE);
            ResponseFilter first = null;
            ResponseFilter current = null;
            // 构建过滤器链
            for (ResponseFilter responseFilter : filterList) {
                if (first == null) {
                    first = current = responseFilter;
                } else {
                    current.setNext(responseFilter);
                    current = responseFilter;
                }
            }
            this.filter = first;
        }
    }

    /**
     * 具体执行过滤方法。
     *
     * @param body                  原始返回数据
     * @param returnType            返回类型
     * @param selectedContentType   选中的内容类型
     * @param selectedConverterType 选择的转换类型
     * @param request               请求对象
     * @param response              响应体
     * @return java.lang.Object 响应数据
     * @author zeroable
     * @date 2024/1/5 14:28
     */
    public Object filter(Object body, MethodParameter returnType, MediaType selectedContentType,
                         Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                         ServerHttpResponse response) {
        if (filter == null) {
            return null;
        }
        return filter.filter(body, returnType, selectedContentType, selectedConverterType, request, response);
    }
}
