package cn.zeroable.cat4j.base.mapper;

import cn.zeroable.cat4j.base.entity.DictItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * 字典明细;(cat4j_dict_item)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:35:21
 * @since 0.0.1
 */
@Mapper
public interface DictItemMapper extends BaseMapper<DictItemEntity> {
}