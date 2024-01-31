package cn.zeroable.cat4j.base.mapper;

import cn.zeroable.cat4j.base.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色表;(cat4j_role)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

     List<RoleEntity> getRolesByUserId(Long userId);

 }