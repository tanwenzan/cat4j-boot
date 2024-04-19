package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.dto.MetaObjectAddDTO;
import cn.zeroable.cat4j.base.vo.TableInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.zeroable.cat4j.base.entity.MetaObjectEntity;

import java.util.List;

/**
 * 元对象;(cat4j_meta_object) 表服务接口
 * @author : tanwenzan
 * @version : 2024-03-01 11:06:11
 * @since 0.0.1
 */
public interface MetaObjectService extends IService<MetaObjectEntity> {

     void addMetaObject(MetaObjectAddDTO metaObject);

     List<TableInfoVO> tableList(String tableName);

 }