package cn.zeroable.cat4j.support;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页工具.
 *
 * @author zeroable
 * @version 2023/8/18 10:09
 * @since 0.0.1
 */
@Data
@Accessors(chain = true)
public class Query {

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 每页的数量
     */
    private Integer size;

    /**
     * 排序的字段名
     */
    private String asc;

    /**
     * 排序方式
     */
    private String desc;
}
