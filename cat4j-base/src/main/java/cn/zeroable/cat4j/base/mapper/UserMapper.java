package cn.zeroable.cat4j.base.mapper;

import cn.zeroable.cat4j.base.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * 用户表;(cat4j_user)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
}