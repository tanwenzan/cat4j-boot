package cn.zeroable.cat4j.base.service.metaobject.impl;

import cn.zeroable.cat4j.base.mapper.MetaObjectMapper;
import cn.zeroable.cat4j.base.service.metaobject.AbstractMetaObjectCreator;
import cn.zeroable.cat4j.base.service.metaobject.MetaObjectCreateType;
import cn.zeroable.cat4j.base.service.metaobject.MetaObjectDataBaseConfig;
import cn.zeroable.cat4j.base.service.metaobject.MetaObjectRenderContext;
import cn.zeroable.cat4j.base.vo.ColumnInfoVO;
import cn.zeroable.cat4j.base.vo.MetaObjectRenderVO;
import cn.zeroable.cat4j.core.exception.BiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * DB数据源元数据创建器.
 * <br/> 通过查询db的方式去生成元数据.
 *
 * @author zeroable
 * @version 2024/6/16 18:44
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class MetaObjectDataBaseCreator extends AbstractMetaObjectCreator<MetaObjectDataBaseConfig> {

    private DataSource dataSource;

    private MetaObjectMapper metaObjectMapper;

    @Override
    public MetaObjectCreateType getType() {
        return MetaObjectCreateType.DB;
    }

    @Override
    protected MetaObjectRenderVO renderMetaObject(MetaObjectRenderContext<MetaObjectDataBaseConfig> context) {
        MetaObjectDataBaseConfig metaObjectDataBaseConfig = context.getConfig();
        String dbName = "";
        try {
            dbName = dataSource.getConnection().getCatalog();
        } catch (SQLException e) {
            throw new BiException(e.getMessage(), e);
        }
        List<ColumnInfoVO> columnInfoVOList = metaObjectMapper.getColumInfo(dbName, metaObjectDataBaseConfig.getTableName());
        return null;
    }

}
