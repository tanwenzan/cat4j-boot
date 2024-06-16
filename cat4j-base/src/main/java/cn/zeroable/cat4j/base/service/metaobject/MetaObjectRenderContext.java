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
public class MetaObjectRenderContext {

    /** 元对象渲染类型 */
    private Integer type;

    private String value;
}
