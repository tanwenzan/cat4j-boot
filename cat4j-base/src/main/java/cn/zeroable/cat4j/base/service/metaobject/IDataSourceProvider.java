package cn.zeroable.cat4j.base.service.metaobject;

import javax.sql.DataSource;

/**
 * 数据源提供者.
 *
 * @author zeroable
 * @version 2024/7/12 0:42
 * @since 0.0.1
 */
public interface IDataSourceProvider {

    /**
     * 根据元对象数据源配置获取DataSource。
     *
     * @param metaObjectDataBaseConfig 元数据数据源配置
     * @return javax.sql.DataSource 数据源
     * @author zeroable
     * @date 2024/7/12 0:44
     */
    DataSource getDataSource(MetaObjectDataBaseConfig metaObjectDataBaseConfig);

}
