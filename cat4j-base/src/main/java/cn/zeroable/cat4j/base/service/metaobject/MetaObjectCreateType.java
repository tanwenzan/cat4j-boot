package cn.zeroable.cat4j.base.service.metaobject;

import lombok.Getter;

/**
 * 元数据创建类型.
 *
 * @author tanwenzan
 * @version 2024/6/12 17:10
 * @since 0.0.1
 */
@Getter
public enum MetaObjectCreateType {

    DB(1, "数据库"),
    JSON(2, "JSON"),
    DML(3, "DML");

    private final Integer value;

    private final String name;

    MetaObjectCreateType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

}
