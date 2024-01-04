package cn.zeroable.cat4j.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.zeroable.cat4j.base.entity.DictItemPO;

 /**
 * 字典明细;(cat4j_dict_item)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:35:21
 * @since 0.0.1
 */
@Mapper
public interface DictItemMapper extends BaseMapper<DictItemPO> {
}