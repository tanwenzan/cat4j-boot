package cn.zeroable.cat4j.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IconItemVO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 图标标识
     */
    private String key;

    /**
     * 图标名称
     */
    private String value;
}
