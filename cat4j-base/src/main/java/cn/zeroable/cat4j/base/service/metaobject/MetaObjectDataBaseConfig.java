package cn.zeroable.cat4j.base.service.metaobject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 元对象数据库配置.
 *
 * @author zeroable
 * @version 2024/6/16 17:37
 * @since 0.0.1
 */
@Data
public class MetaObjectDataBaseConfig {

    /**
     * 表名称
     */
    @NotBlank(message = "表名称不能为空")
    private String tableName;

    /**
     * 数据源
     */
    @NotBlank(message = "数据源不能为空")
    private String dataSource;

    /**
     * 主键值
     */
    private String pkName;

    /**
     * 类型:0=视图,1=表
     */
    @NotNull(message = "类型不能为空")
    private Integer type;
}
