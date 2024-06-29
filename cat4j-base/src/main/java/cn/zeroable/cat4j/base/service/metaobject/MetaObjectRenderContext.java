package cn.zeroable.cat4j.base.service.metaobject;

import lombok.Data;

/**
 * 元对象渲染上下文.
 *
 * @author tanwenzan
 * @version 2024/6/12 17:18
 * @since 0.0.1
 */
@Data
public class MetaObjectRenderContext<T> {

    /**
     * 元对象渲染类型
     */
    private Integer type;

    /**
     * 元数据配置
     */
    private T config;

    public static <T> MetaObjectRenderContext<T> byConfig(Integer type, T config) {
        MetaObjectRenderContext<T> context = new MetaObjectRenderContext<>();
        context.setType(type);
        context.setConfig(config);
        return context;
    }

}
