package cn.zeroable.cat4j.security.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * 鉴权配置提供者.
 * <br/> 对外模块提供鉴权配置接口.
 *
 * @author zeroable
 * @version 2024/1/12 18:14
 * @since 0.0.1
 */
public interface ISecurityConfigProvider {

    /**
     * 获取登录检测匹配。
     * <br/>详细说明
     *
     * @return java.lang.String[]
     * @author zeroable
     * @date 2024/1/12 18:33
     */
    String[] getLoginPathPatterns();


    /**
     * 获取不需要进行登录的路径。
     *
     * @return java.lang.String[] 不需要进行登录的路径
     * @author zeroable
     * @date 2024/1/12 18:54
     */
    String[] getLoginNotMatch();

    /**
     * 添加检测项。
     *
     * @param registry Helps with configuring a list of mapped interceptors.
     * @author zeroable
     * @date 2024/1/12 18:29
     */
    void addCheck(InterceptorRegistry registry);
}
