package cn.zeroable.cat4j.base.enums;

import cn.zeroable.cat4j.core.util.AssertUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录设备枚举类.
 *
 * @author zeroable
 * @version 2024/10/28 23:28
 * @since 0.0.1
 */
@Getter
public enum LoginDeviceType {

    Web("WEB", 1),
    Android("Android", 10),
    IOS("IOS", 20),
    IPad("Ipad", 30);

    private final String name;
    private final int value;
    private static final Map<Integer, LoginDeviceType> CACHE_TYPE = new HashMap<>();

    static {
        for (LoginDeviceType type : LoginDeviceType.values()) {
            CACHE_TYPE.put(type.getValue(), type);
        }
    }

    LoginDeviceType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static LoginDeviceType valueOf(int value) {
        AssertUtil.isTrue(CACHE_TYPE.containsKey(value), "no such device type: " + value);
        return CACHE_TYPE.get(value);
    }

}
