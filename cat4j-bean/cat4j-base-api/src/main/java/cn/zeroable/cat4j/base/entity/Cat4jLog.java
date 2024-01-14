package cn.zeroable.cat4j.base.entity;

import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统日志 POJO;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:36:21
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class Cat4jLog extends BaseEntity implements Serializable, Cloneable {

    /**
     * 日志类型
     */
    private Integer type;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * ip地址
     */
    private String remoteAddr;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 操作方式
     */
    private String method;

    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * 执行时间
     */
    private Integer time;

    @Override
    public Cat4jLog clone() {
        return (Cat4jLog) super.clone();
    }
}