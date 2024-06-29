package cn.zeroable.cat4j.base.vo;

import lombok.Data;

import java.util.List;

/**
 * 元对象渲染View Object.
 *
 * @author zeroable
 * @version 2024/6/16 18:02
 * @since 0.0.1
 */
@Data
public class MetaObjectRenderVO {

    /**
     * 元字段
     */
    private List<MetaFieldVO> fields;

}
