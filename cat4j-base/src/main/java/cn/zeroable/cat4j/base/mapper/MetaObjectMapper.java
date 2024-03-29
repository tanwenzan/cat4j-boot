package cn.zeroable.cat4j.base.mapper;

import cn.zeroable.cat4j.base.entity.MetaObjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
 /**
 * 元对象;(cat4j_meta_object)表数据库访问层
 *
 * @author : zeroable
 * @version : 2024-03-01 11:06:11
 * @since 0.0.1
 */
@Mapper
public interface MetaObjectMapper extends BaseMapper<MetaObjectEntity> {
}