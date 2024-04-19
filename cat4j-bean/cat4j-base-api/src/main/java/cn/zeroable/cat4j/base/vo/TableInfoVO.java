package cn.zeroable.cat4j.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TableInfoVO
 *
 * @author : zeroable
 * @version : 2024年3月10日 17:46:04
 * @since 0.0.1
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TableInfoVO {
    /**
     * 数据库名称
     */
    private String dbName;
    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表备注
     */
    private String tableComment;
}
