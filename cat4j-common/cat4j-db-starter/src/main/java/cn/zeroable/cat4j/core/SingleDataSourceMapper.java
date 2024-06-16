package cn.zeroable.cat4j.core;

import cn.zeroable.cat4j.config.Cat4jDbConstant;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单数据源列表
 *
 * @author zeroable
 * @version 2024/6/11 16:41
 * @since 0.0.1
 */
@Service
public class SingleDataSourceMapper implements DataSourceMapper {

    @Resource
    private DataSource dataSource;

    @Value("${spring.datasource.name:cat4j-base}")
    private String key;

    @Override
    public String getType() {
        return Cat4jDbConstant.DATA_SOURCE_SINGLE;
    }

    @Override
    public Map<String, DataSource> mapping() {
        Map<String, DataSource> mapping = new ConcurrentHashMap<>();
        mapping.put(key, dataSource);
        return mapping;
    }
}
