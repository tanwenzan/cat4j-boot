package cn.zeroable.cat4j.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.zeroable.cat4j.base.entity.MetaFieldEntity;

/**
 * 元字段;(cat4j_meta_field)表数据库访问层
 *
 * @author : zeroable
 * @version : 2024-03-01 11:07:11
 * @since 0.0.1
 */
@Mapper
public interface MetaFieldMapper extends BaseMapper<MetaFieldEntity> {
}