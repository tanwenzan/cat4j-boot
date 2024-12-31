package cn.zeroable.cat4j.base.dto;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import jakarta.validation.constraints.NotBlank;
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
     * 元数据编码
     */
    @NotBlank(message = "元数据编码不能为空")
    private String code;

    /**
     * 元数据名称
     */
    @NotBlank(message = "元数据名称不能为空")
    private String name;

    /**
     * 主键值
     */
    @TableField("pk_name")
    private String pkName;

    /**
     * 类型:0=视图,1=表
     */
    @TableField("data_type")
    private Integer dataType;

    /**
     * 数据源
     */
    @TableField("data_source")
    private String dataSource;

    /**
     * 是否单选
     */
    @TableField("single_flag")
    private Boolean singleFlag;

    /**
     * 是否初始加载
     */
    @TableField("first_load_flag")
    private Boolean firstLoadFlag;

    /**
     * 是否显示行号
     */
    @TableField("show_line_number_flag")
    private Boolean showLineNumberFlag;

    /**
     * 是否详细模式
     */
    @TableField("detail_model_flag")
    private Boolean detailModelFlag;

    /**
     * 初始数据过滤条件
     */
    @TableField("filter")
    private String filter;

    /**
     * 默认排序字段(desc)
     */
    @TableField("default_order")
    private String defaultOrder;

    /**
     * 表名称
     */
    @TableField("table_name")
    private String tableName;

    /**
     * 拦截器
     */
    @TableField("interceptor")
    private String interceptor;

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
