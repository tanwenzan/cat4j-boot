package cn.zeroable.cat4j.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 路由元信息.
 * <br/> 一些额外的配置都放在这里面.
 *
 * @author zeroable
 * @version 1/13/24 10:44 PM
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RouterMetaInfo {

    /**
     * 当设置 true 的时候该路由不会再侧边栏出现 如404，login等页面(默认 false)
     */
    private Boolean hidden;

    /**
     * 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式，
     * 只有一个时，会将那个子路由当做根路由显示在侧边栏，
     * 若你想不管路由下面的 children 声明的个数都显示你的根路由，
     * 你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，
     * 一直显示根路由(默认 false)
     */
    private Boolean alwaysShow;

    /**
     * 设置该路由在侧边栏和面包屑中展示的名字
     */
    private String title;

    /**
     * 设置该路由的图标
     */
    private String icon;

    /**
     * 如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
     */
    private Boolean noCache;

    /**
     * 如果设置为false，则不会在breadcrumb面包屑中显示(默认 true)
     */
    private Boolean breadcrumb;

    /**
     * 如果设置为true，则会一直固定在tag项中(默认 false)
     */
    private Boolean affix;

    /**
     * 设置该路由的权限
     */
    private List<String> permission;

}
