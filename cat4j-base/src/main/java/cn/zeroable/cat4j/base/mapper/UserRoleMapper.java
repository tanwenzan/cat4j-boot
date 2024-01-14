package cn.zeroable.cat4j.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.zeroable.cat4j.base.entity.UserRole;

import java.util.List;

/**
 * 用户角色表;(cat4j_user_role)表数据库访问层
 *
 * @author : zeroable
 * @version : 2024-01-12 000:48:00
 * @since 0.0.1
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 查找用户对应的角色。
     *
     * @param userId 用户id
     * @return java.util.List<java.lang.String>
     * @author zeroable
     * @date 1/12/24 12:55 AM
     */
    List<String> getRoleCodeByUserId(Long userId);

}