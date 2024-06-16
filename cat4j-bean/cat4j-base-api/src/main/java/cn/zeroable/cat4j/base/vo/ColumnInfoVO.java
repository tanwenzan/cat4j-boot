package cn.zeroable.cat4j.base.vo;

import lombok.Data;

/**
 * 元字段字段信息.
 *
 * @author zeroable
 * @version 2024/5/31 16:24
 * @since 0.0.1
 */
@Data
public class ColumnInfoVO {

    /**
     * 列名称
     */
    private String columnName;

    /**
     * 备注
     */
    private String comment;

    /**
     * 所属表名称
     */
    private String tableName;

    /**
     * 所属数据库名称
     */
    private String dbName;

    /**
     * 排序
     */
    private Integer orderNo;

    /**
     * 是否能为空
     */
    private Boolean isNullable;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 数据长度
     */
    private Integer dataLen;

    /**
     * 默认值
     */
    private String defaultVal;

    /**
     * 是否是主键
     */
    private Boolean isPri;

}
