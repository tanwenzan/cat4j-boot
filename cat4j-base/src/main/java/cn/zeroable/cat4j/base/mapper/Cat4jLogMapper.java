package cn.zeroable.cat4j.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.zeroable.cat4j.base.po.Cat4jLog;

 /**
 * 系统日志;(cat4j_log)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:36:21
 * @since 0.0.1
 */
@Mapper
public interface Cat4jLogMapper extends BaseMapper<Cat4jLog> {
}