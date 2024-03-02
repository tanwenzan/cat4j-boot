package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.dto.MetaObjectAddDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.zeroable.cat4j.base.entity.MetaObjectEntity;

 /**
 * 元对象;(cat4j_meta_object) 表服务接口
 * @author : tanwenzan
 * @version : 2024-03-01 11:06:11
 * @since 0.0.1
 */
public interface MetaObjectService extends IService<MetaObjectEntity> {

     void addMetaObject(MetaObjectAddDTO metaObject);

}