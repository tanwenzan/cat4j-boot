package cn.zeroable.cat4j.base.mapper;

import cn.zeroable.cat4j.base.entity.DictEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * 字典表;(cat4j_dict)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:35:21
 * @since 0.0.1
 */
@Mapper
public interface DictMapper extends BaseMapper<DictEntity> {
}