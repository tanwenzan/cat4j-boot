package cn.zeroable.cat4j.base.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IconVO extends HashMap<Integer, List<IconItemVO>> implements Serializable {

    public IconVO(Map<Integer, List<IconItemVO>> groupByType) {
        super(groupByType);
    }
}
