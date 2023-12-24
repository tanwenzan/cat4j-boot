package cn.zeroable.cat4j.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 自定义序列化器 将Long类型数据转成String.
 * <br/> 处理返回前端数据精度丢失问题.
 *
 * @author zeroable
 * @version 12/24/23 10:06 PM
 * @since 0.0.1
 */
public class Long2StringSerializer extends JsonSerializer<Long> {

    @Override
    public void serialize(Long value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            jsonGenerator.writeString(value.toString());
        }
    }
}
