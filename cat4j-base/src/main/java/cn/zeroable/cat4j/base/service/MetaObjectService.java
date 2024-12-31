package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.dto.MetaObjectAddDTO;
import cn.zeroable.cat4j.base.vo.TableInfoVO;
import cn.zeroable.cat4j.support.Query;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.zeroable.cat4j.base.entity.MetaObjectEntity;

import java.util.List;

/**
 * 元对象;(cat4j_meta_object) 表服务接口
 *
 * @author : zeroable
 * @version : 2024-03-01 11:06:11
 * @since 0.0.1
 */
public interface MetaObjectService extends IService<MetaObjectEntity> {

    /**
     * 添加元对象信息。
     * <br/>
     *
     * @param metaObject 元对象DTO
     * @throws cn.zeroable.cat4j.core.exception.BiException 业务出现异常时抛出
     * @author zeroable
     * @date 2024/10/28 21:57
     */
    void addMetaObject(MetaObjectAddDTO metaObject);

    IPage<TableInfoVO> tableList(String tableName, Query query);

}