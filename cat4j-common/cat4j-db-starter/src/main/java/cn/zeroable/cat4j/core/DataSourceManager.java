package cn.zeroable.cat4j.core;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.zeroable.cat4j.core.exception.BiException;
import cn.zeroable.cat4j.core.util.AssertUtil;
import cn.zeroable.cat4j.dto.DataSourceManagerDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 数据源管理器
 *
 * @author zeroable
 * @version 2024/6/11 14:40
 * @since 0.0.1
 */
@Slf4j
@Component
@AutoConfigureBefore({DataSourceMapperFactory.class})
public class DataSourceManager implements InitializingBean {

    @Resource
    private DataSourceMapperFactory dataSourceMapperFactory;

    @Value("${spring.datasource.way:dataSourceSingle}")
    private String type;
    private final Map<String, DataSourceManagerDTO> dataSourceMapping = new ConcurrentHashMap<>();

    private final AtomicBoolean init = new AtomicBoolean(false);

    private void initDataSourceMapping() {
        AssertUtil.isFalse(init.get(), "禁止重复初始化");
        AssertUtil.isTrue(dataSourceMapperFactory.containsObject(type), "不存在这样的数据源映射器：" + type);
        DataSourceMapper dataSourceMapper = dataSourceMapperFactory.getObject(type);
        Map<String, DataSource> dataSourceMap = dataSourceMapper.mapping();
        if (ObjectUtil.isNotEmpty(dataSourceMap)) {
            dataSourceMap.forEach((key, datasource) -> dataSourceMapping.put(key, new DataSourceManagerDTO(key, false, datasource)));
            init.compareAndExchange(false, true);
        }
    }

    public List<String> getDatasourceNames() {
        return new ArrayList<>(dataSourceMapping.keySet());
    }

    /**
     * 添加数据源。
     * <br/> 只能添加不存在的数据源
     *
     * @param key        数据源key
     * @param dataSource 数据源
     * @throws BiException 数据源存在时抛出
     * @author zeroable
     * @date 2024/6/12 9:53
     */
    public void addDataSourceMapping(String key, DataSourceManagerDTO dataSource) {
        AssertUtil.isFalse(dataSourceMapping.containsKey(key), "数据源已存在，禁止重复添加");
        dataSourceMapping.putIfAbsent(key, dataSource);
    }

    /**
     * 动态移除数据源。
     * <br/> 只能移除那些允许删除的
     *
     * @param key 数据源 key
     * @throws BiException 当数据源禁止删除时抛出
     * @author zeroable
     * @date 2024/6/12 9:53
     */
    public void delDataSourceMapping(String key) {
        // 不存在就直接跳过了
        if (!dataSourceMapping.containsKey(key)) {
            return;
        }
        // 只能移除那些允许删除的
        DataSourceManagerDTO dataSourceManagerDTO = dataSourceMapping.get(key);
        AssertUtil.isTrue(BooleanUtil.isTrue(dataSourceManagerDTO.getIsAllowDel()), "该数据源禁止删除");
        dataSourceMapping.remove(key);
    }

    @Override
    public void afterPropertiesSet() {
        initDataSourceMapping();
    }
}

