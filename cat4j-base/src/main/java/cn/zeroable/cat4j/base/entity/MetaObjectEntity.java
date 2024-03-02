package cn.zeroable.cat4j.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

 /**
 * 元对象;
 * @author : zeroable
 * @version : 2024-03-01 11:06:11
 * @since 0.0.1
 */
@TableName("cat4j_meta_object")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class MetaObjectEntity extends BaseEntity implements Serializable, Cloneable {
    
    
    /** 元对象名称 */
    @TableField("name")
    private String name;
    
    /** 元对象编码 */
    @TableField("code")
    private String code;
    
    /** 主键值 */
    @TableField("pk_name")
    private String pkName;
    
    /** 类型:0=视图,1=表 */
    @TableField("type")
    private Integer type;
    
    /** 数据源 */
    @TableField("data_source")
    private String dataSource;
    
    /** 是否单选 */
    @TableField("single_flag")
    private Boolean singleFlag;
    
    /** 是否初始加载 */
    @TableField("first_load_flag")
    private Boolean firstLoadFlag;
    
    /** 是否显示行号 */
    @TableField("show_line_number_flag")
    private Boolean showLineNumberFlag;
    
    /** 是否详细模式 */
    @TableField("detail_model_flag")
    private Boolean detailModelFlag;
    
    /** 初始数据过滤条件 */
    @TableField("filter")
    private String filter;
    
    /** 默认排序字段(desc) */
    @TableField("default_order")
    private String defaultOrder;
    
    /** 表名称 */
    @TableField("table_name")
    private String tableName;
    
    /** 拦截器 */
    @TableField("interceptor")
    private String interceptor;
    
    /** 元对象配置 */
    @TableField("config")
    private String config;
    
    /** 创建时间 */
    @TableField("created_time")
    private Date createdTime;
    
    
    
    
    
    
    
    
    
    @Override
    public MetaObjectEntity clone() {
        return (MetaObjectEntity) super.clone();
    }
}