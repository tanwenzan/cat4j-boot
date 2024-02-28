package cn.zeroable.cat4j.base.mapper;

import cn.zeroable.cat4j.base.entity.IconEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * 图标表;(cat4j_icon)表数据库访问层
 *
 * @author : zeroable
 * @version : 2024-02-07 10:08:10
 * @since 0.0.1
 */
@Mapper
public interface IconMapper extends BaseMapper<IconEntity> {
}