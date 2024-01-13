package cn.zeroable.cat4j.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.zeroable.cat4j.base.po.Role;

 /**
 * 角色表;(cat4j_role)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}