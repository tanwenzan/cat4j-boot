package cn.zeroable.cat4j.entity;

import cn.zeroable.cat4j.core.Long2StringSerializer;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 数据库基础实体类.
 *
 * @author zeroable
 * @version 12/24/23 10:02 PM
 * @since 0.0.1
 */
public class BasePO {

    //使用自己实现的类型转换
    @TableId
    @JsonSerialize(using = Long2StringSerializer.class)
    private Long id;

    @Version
    private Integer version;

    @TableLogic
    private Boolean hide;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }
}
