package cn.zeroable.cat4j.base.mapper;

import cn.zeroable.cat4j.base.entity.RoleMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色权限表;(cat4j_role_menu)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity> {

    List<String> getPermissionList(@Param("userId") Object userId);

}