package cn.zeroable.cat4j.base.service.impl;

import cn.zeroable.cat4j.base.dto.MetaObjectAddDTO;
import cn.zeroable.cat4j.base.mapper.MetaFieldMapper;
import cn.zeroable.cat4j.base.vo.ColumnInfoVO;
import cn.zeroable.cat4j.base.vo.TableInfoVO;
import cn.zeroable.cat4j.core.exception.BiException;
import cn.zeroable.cat4j.core.util.AssertUtil;
import cn.zeroable.cat4j.support.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.MetaObjectEntity;
import cn.zeroable.cat4j.base.mapper.MetaObjectMapper;
import cn.zeroable.cat4j.base.service.MetaObjectService;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * 元对象;(cat4j_meta_object)表服务实现类
 *
 * @author : zeroable
 * @version : 2024-03-01 11:06:11
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class MetaObjectServiceImpl extends ServiceImpl<MetaObjectMapper, MetaObjectEntity> implements MetaObjectService {

    private DataSource dataSource;

    @Override
    @Transactional
    public void addMetaObject(MetaObjectAddDTO metaObject) {
        String name = metaObject.getName();
        String code = metaObject.getCode();
        AssertUtil.isFalse(isExit(code, name), "元对象名称或者编码已存在，请重新填写");
        String dbName = "";
        try {
            dbName = dataSource.getConnection().getCatalog();
        } catch (SQLException e) {
            throw new BiException(e.getMessage(), e);
        }
        List<ColumnInfoVO> columnInfoVOList = this.baseMapper.getColumInfo(dbName, metaObject.getTableName());
        AssertUtil.notEmpty(columnInfoVOList, "表信息不存在，请检查后再试");
        ColumnInfoVO columnInfoVO = columnInfoVOList.stream().filter(ColumnInfoVO::getIsPri).findFirst()
                .orElse(null);

    }

    @Override
    public IPage<TableInfoVO> tableList(String tableName, Query query) {
        try {
            String dbName = dataSource.getConnection().getCatalog();
            query = Query.getQuery(query);
            return this.baseMapper.getTableList(dbName, tableName, query.toPage());
        } catch (Exception e) {
            throw new BiException(e.getMessage(), e);
        }
    }

    private boolean isExit(String code, String name) {
        return null != getOne(new QueryWrapper<MetaObjectEntity>().lambda().eq(MetaObjectEntity::getCode, code)
                .or().eq(MetaObjectEntity::getName, name));
    }
}