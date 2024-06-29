package cn.zeroable.cat4j.base.vo;


import lombok.Data;

/**
 * 元对象字段VO.
 *
 * @author zeroable
 * @version 2024/6/16 18:03
 * @since 0.0.1
 */
@Data
public class MetaFieldVO {
    /**
     * 序号
     */
    private Integer order;

    /**
     * 字段
     */
    private String code;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段类型
     */
    private String filedType;

    /**
     * 是否显示
     */
    private Boolean showFlag;

    /**
     * 是否查询
     */
    private Boolean queryFlag;

    /**
     * 新增状态:0=正常,10=只读,20=隐藏,50=禁用
     */
    private String addStatus;

    /**
     * 修改状态:0=正常,10=只读,20=隐藏,50=禁用
     */
    private String updateStatus;

    /**
     * 是否可排序
     */
    private Boolean orderFlag;

    /**
     * 是否禁用
     */
    private Boolean disableFlag;

    /**
     * 是否必填
     */
    private Boolean requiredFlag;

    /**
     * 是否多选项
     */
    private String multipleFlag;

    /**
     * 组件表达式
     */
    private String exp;

    /**
     * 输入提示
     */
    private String placeholder;

    /**
     * 点击小提示
     */
    private String tips;

    /**
     * UI校验器
     */
    private String validator;

    /**
     * 默认值
     */
    private String defaultVal;

    /**
     * 格式化
     */
    private String format;

    /**
     * 宽度
     */
    private String width;

    /**
     * 高度
     */
    private String height;

    /**
     * 扩展配置
     */
    private String config;
}
