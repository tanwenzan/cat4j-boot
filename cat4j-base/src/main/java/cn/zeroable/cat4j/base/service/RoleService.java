package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.po.RolePO;
import cn.zeroable.cat4j.base.vo.RoleVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色表;(cat4j_role) 表服务接口
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
public interface RoleService extends IService<RolePO> {

    List<RoleVO> getRolesByUserId(Long userId);
}