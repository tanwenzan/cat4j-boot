package cn.zeroable.cat4j.base.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 新增元对象DTO.
 *
 * @author tanwenzan
 * @version 2024/3/1 11:49
 * @since 0.0.1
 */
@Data
public class MetaObjectAddDTO {

    /**
     * 元对象编码
     */
    @NotBlank(message = "元对象编码不能为空")
    private String code;

    /**
     * 元对象名称
     */
    @NotBlank(message = "元对象名称不能为空")
    private String name;

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
