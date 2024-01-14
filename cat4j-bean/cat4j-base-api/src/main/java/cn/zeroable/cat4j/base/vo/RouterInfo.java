package cn.zeroable.cat4j.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 路由信息.
 *
 * @author zeroable
 * @version 1/13/24 10:43 PM
 * @since 0.0.1
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RouterInfo {

    private String name;

    private String path;

    private String redirect;

    private String component;

    private List<RouterInfo> children;

    private RouterMetaInfo meta;

}
