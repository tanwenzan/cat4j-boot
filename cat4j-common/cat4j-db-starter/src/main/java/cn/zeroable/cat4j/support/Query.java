package cn.zeroable.cat4j.support;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class Query {

    /**
     * 默认的起始页
     */
    public static final long DEFAULT_CURRENT = 1L;

    /**
     * 默认的每页数量
     */
    public static final long DEFAULT_LIMIT = 20L;

    /**
     * 默认的偏移量
     */
    public static final long DEFAULT_OFFSET = 0L;

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

    public long current() {
        long current = DEFAULT_CURRENT;
        if (this.current != null) {
            current = getCurrent();
        }
        return current;
    }

    public long offset() {
        long current = current();
        if (current <= 1L) {
            return 0L;
        }
        return Math.max((current - 1) * limit(), 0L);
    }

    public long limit() {
        long limit = DEFAULT_LIMIT;
        if (this.size != null) {
            limit = this.size;
        }
        return limit;
    }

    public <T> Page<T> toPage() {
        return new Page<>(current(), limit());
    }

    public static Query getQuery(Query query) {
        // 如果query对象是正常的，那么直接返回即可
        if (query != null && query.getCurrent() != null && query.getSize() != null) {
            return query;
        }
        // 反之需要构造一个默认的 Query
        return new Query(Long.valueOf(DEFAULT_CURRENT).intValue(), Long.valueOf(DEFAULT_LIMIT).intValue(), null, null);
    }
}
