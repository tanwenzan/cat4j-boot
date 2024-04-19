package cn.zeroable.cat4j.base.service.impl;

import cn.zeroable.cat4j.base.dto.MetaObjectAddDTO;
import cn.zeroable.cat4j.base.vo.TableInfoVO;
import cn.zeroable.cat4j.core.exception.BiException;
import cn.zeroable.cat4j.core.util.AssertUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.MetaObjectEntity;
import cn.zeroable.cat4j.base.mapper.MetaObjectMapper;
import cn.zeroable.cat4j.base.service.MetaObjectService;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
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
    public void addMetaObject(MetaObjectAddDTO metaObject) {
        String name = metaObject.getName();
        String code = metaObject.getCode();
        AssertUtil.isFalse(isExit(code, name), "元对象名称或者编码已存在，请重新填写");

    }

    @Override
    public List<TableInfoVO> tableList(String tableName) {
        try {
            String dbName = dataSource.getConnection().getCatalog();
            return this.baseMapper.getTableList(dbName, tableName);
        } catch (Exception e) {
            throw new BiException(e.getMessage(), e);
        }
    }

    private boolean isExit(String code, String name) {
        return null != getOne(new QueryWrapper<MetaObjectEntity>().lambda().eq(MetaObjectEntity::getCode, code)
                .or().eq(MetaObjectEntity::getName, name));
    }

}