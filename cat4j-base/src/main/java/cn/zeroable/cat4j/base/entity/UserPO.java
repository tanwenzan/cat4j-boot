package cn.zeroable.cat4j.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BasePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

 /**
 * 用户表;
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@TableName("cat4j_user")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class UserPO extends BasePO implements Serializable, Cloneable {
    /** 主键 */
    @TableId("id")
    private Long id;
    
    
    
    
    
    
    
    
    
    
    /** 账号 */
    @TableField("loginId")
    private String loginId;
    
    /** 密码 */
    @TableField("loginPwd")
    private String loginPwd;
    
    /** 用户名 */
    @TableField("userName")
    private String userName;
    
    /** 所属组织 */
    @TableField("orgId")
    private  orgId;
    
    /** 随机盐 */
    @TableField("salt")
    private String salt;
    
    /** 头像 */
    @TableField("avatar")
    private String avatar;
    
    /** 手机号码 */
    @TableField("phoneNumber")
    private String phoneNumber;
    
    /** 邮箱 */
    @TableField("email")
    private String email;
    
    /** 简介 */
    @TableField("introduction")
    private String ntroduction;
    
    /** 锁定标识:0=正常,1=锁定 */
    @TableField("lockFlag")
    private Integer lockFlag;
    
    /** 创建时间 */
    @TableField("createBy")
    private Date createBy;
    
    /** 创建时间 */
    @TableField("createTime")
    private Date createTime;
    
    /** 更新人 */
    @TableField("updateBy")
    private  updateBy;
    
    /** 更新时间 */
    @TableField("updateTime")
    private Date updateTime;
    
    /** 乐观锁 */
    @TableField("reVersion")
    private Integer reVersion;
    
    /** 逻辑删除 */
    @TableField("hide")
    private  hide;

    @Override
    public UserPO clone() {
        return (UserPO) super.clone();
    }
}