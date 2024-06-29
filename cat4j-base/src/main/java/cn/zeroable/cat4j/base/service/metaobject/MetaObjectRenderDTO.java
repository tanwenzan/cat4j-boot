package cn.zeroable.cat4j.base.service.metaobject;

import cn.hutool.json.JSONObject;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 渲染元对象DTO.
 *
 * @author zeroable
 * @version 2024/3/1 11:49
 * @since 0.0.1
 */
@Data
public class MetaObjectRenderDTO {

    /**
     * 元数据类型
     */
    @NotNull(message = "元数据类型不能为空")
    private Integer type;

    /**
     * 元数据配置
     */
    @NotNull(message = "元数据配置不能为空")
    private JSONObject config;

}
