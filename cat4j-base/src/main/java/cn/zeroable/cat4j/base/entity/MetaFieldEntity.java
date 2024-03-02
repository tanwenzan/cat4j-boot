package cn.zeroable.cat4j.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 元字段;
 *
 * @author : zeroable
 * @version : 2024-03-01 11:07:11
 * @since 0.0.1
 */
@TableName("cat4j_meta_field")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class MetaFieldEntity extends BaseEntity implements Serializable, Cloneable {


    /**
     * 所属元对象
     */
    @TableField("meta_object_id")
    private Long metaObjectId;

    /**
     * 所属元对象编码
     */
    @TableField("meta_object_code")
    private String metaObjectCode;

    /**
     * 序号
     */
    @TableField("order")
    private Integer order;

    /**
     * 字段
     */
    @TableField("code")
    private String code;

    /**
     * 字段名称
     */
    @TableField("name")
    private String name;

    /**
     * 字段类型
     */
    @TableField("filed_type")
    private String filedType;

    /**
     * 是否显示
     */
    @TableField("show_flag")
    private Boolean showFlag;

    /**
     * 是否查询
     */
    @TableField("query_flag")
    private Boolean queryFlag;

    /**
     * 新增状态:0=正常,10=只读,20=隐藏,50=禁用
     */
    @TableField("add_status")
    private String addStatus;

    /**
     * 修改状态:0=正常,10=只读,20=隐藏,50=禁用
     */
    @TableField("update_status")
    private String updateStatus;

    /**
     * 是否可排序
     */
    @TableField("order_flag")
    private Boolean orderFlag;

    /**
     * 是否禁用
     */
    @TableField("disable_flag")
    private Boolean disableFlag;

    /**
     * 是否必填
     */
    @TableField("required_flag")
    private Boolean requiredFlag;

    /**
     * 是否多选项
     */
    @TableField("multiple_flag")
    private String multipleFlag;

    /**
     * 组件表达式
     */
    @TableField("exp")
    private String exp;

    /**
     * 输入提示
     */
    @TableField("placeholder")
    private String placeholder;

    /**
     * 点击小提示
     */
    @TableField("tips")
    private String tips;

    /**
     * UI校验器
     */
    @TableField("validator")
    private String validator;

    /**
     * 默认值
     */
    @TableField("default")
    private String defaultVal;

    /**
     * 格式化
     */
    @TableField("format")
    private String format;

    /**
     * 宽度
     */
    @TableField("width")
    private String width;

    /**
     * 高度
     */
    @TableField("height")
    private String height;

    /**
     * 扩展配置
     */
    @TableField("config")
    private String config;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;


    @Override
    public MetaFieldEntity clone() {
        return (MetaFieldEntity) super.clone();
    }
}