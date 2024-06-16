package cn.zeroable.cat4j.core;

import cn.zeroable.cat4j.core.factory.AbstractObjectFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 数据源映射工厂
 *
 * @author zeroable
 * @version 2024/6/11 14:40
 * @since 0.0.1
 */
@Component
public class DataSourceMapperFactory extends AbstractObjectFactory<DataSourceMapper, String> {

    public DataSourceMapperFactory(Map<String, DataSourceMapper> beansOfType) {
        super(beansOfType);
    }

}

