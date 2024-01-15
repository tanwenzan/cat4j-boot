package cn.zeroable.cat4j.base.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.zeroable.cat4j.base.dto.LoginDTO;
import cn.zeroable.cat4j.base.vo.LoginResult;
import cn.zeroable.cat4j.core.ApiResult;

/**
 * 认证接口.
 *
 * @author zeroable
 * @version 1/11/24 11:53 PM
 * @since 0.0.1
 */
public interface AuthService {

    /**
     * 进行登录。
     *
     * @param loginDTO 登录信息
     * @return cn.zeroable.cat4j.core.ApiResult<cn.dev33.satoken.stp.SaTokenInfo>
     * @author zeroable
     * @date 1/11/24 11:58 PM
     */

    ApiResult<LoginResult> login(LoginDTO loginDTO);

    ApiResult<String> logOut();
}
