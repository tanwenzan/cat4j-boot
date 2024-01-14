package cn.zeroable.cat4j.base.po;

import cn.zeroable.cat4j.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统日志;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:36:21
 * @since 0.0.1
 */
@TableName("cat4j_log")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class Cat4jLogPO extends BasePO implements Serializable, Cloneable {

    /**
     * 日志类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 日志标题
     */
    @TableField("title")
    private String title;

    /**
     * 服务ID
     */
    @TableField("service_id")
    private String serviceId;

    /**
     * ip地址
     */
    @TableField("remote_addr")
    private String remoteAddr;

    /**
     * 用户代理
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * 请求URI
     */
    @TableField("request_uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @TableField("method")
    private String method;

    /**
     * 操作提交的数据
     */
    @TableField("params")
    private String params;

    /**
     * 执行时间
     */
    @TableField("time")
    private Integer time;


    @Override
    public Cat4jLogPO clone() {
        return (Cat4jLogPO) super.clone();
    }
}