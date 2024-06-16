package cn.zeroable.cat4j.core;

import cn.zeroable.cat4j.core.factory.Type;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 数据源 映射器.
 *
 * @author zeroable
 * @version 2024/6/11 14:41
 * @since 0.0.1
 */
public interface DataSourceMapper extends Type<String> {

    /**
     * 数据源映射方法。
     *
     * @author zeroable
     * @date 2024/6/11 14:44
     */
    Map<String, DataSource> mapping();
}
