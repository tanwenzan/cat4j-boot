package cn.zeroable.cat4j.entity;

import cn.zeroable.cat4j.core.Long2StringSerializer;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据库基础实体类.
 *
 * @author zeroable
 * @version 12/24/23 10:02 PM
 * @since 0.0.1
 */
public class BasePO implements Serializable, Cloneable {

    //使用自己实现的类型转换
    @TableId("id")
    @JsonSerialize(using = Long2StringSerializer.class)
    private Long id;

    @Version
    @TableField("re_version")
    private Integer reVersion;

    @TableField("create_by")
    private Long createBy;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("update_by")
    private Long updateBy;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableLogic
    @TableField("hide")
    private Boolean hide;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReVersion() {
        return reVersion;
    }

    public BasePO setReVersion(Integer reVersion) {
        this.reVersion = reVersion;
        return this;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public BasePO setCreateBy(Long createBy) {
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public BasePO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public BasePO setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public BasePO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
