package cn.zeroable.cat4j.base.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.zeroable.cat4j.base.pojo.dto.LoginDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.zeroable.cat4j.base.entity.UserPO;

 /**
 * 用户表;(cat4j_user) 表服务接口
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
public interface UserService extends IService<UserPO> {

       SaTokenInfo login(LoginDTO user);

 }