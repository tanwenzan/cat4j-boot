package cn.zeroable.cat4j.base.dto;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

/**
 * 新增元对象DTO.
 *
 * @author zeroable
 * @version 2024/3/1 11:49
 * @since 0.0.1
 */
@Data
public class MetaObjectAddDTO {

    /**
     * 元对象渲染配置
     */
    @Valid
    private MetaObjectRenderDTO config;

    /**
     * 元字段信息
     */
    @Valid
    private List<MetaFieldDTO> fields;

}
