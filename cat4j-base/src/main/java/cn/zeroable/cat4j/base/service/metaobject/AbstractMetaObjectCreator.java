package cn.zeroable.cat4j.base.service.metaobject;

import cn.hutool.json.JSONUtil;
import cn.zeroable.cat4j.base.dto.MetaObjectRenderDTO;
import cn.zeroable.cat4j.base.vo.MetaObjectRenderVO;
import cn.zeroable.cat4j.core.util.ValidateUtil;
import jakarta.validation.Valid;

import java.lang.reflect.ParameterizedType;

/**
 * 元数据创建器 抽象类.
 *
 * @author zeroable
 * @version 2024/6/16 18:17
 * @since 0.0.1
 */
public abstract class AbstractMetaObjectCreator<T> implements IMetaObjectCreator {

    @Override
    public MetaObjectRenderVO renderMetaObject(@Valid MetaObjectRenderDTO metaObjectRender) {
        Class<T> configClass = getConfigClass();
        T config = JSONUtil.toBean(metaObjectRender.getConfig(), configClass);
        ValidateUtil.validate(config);
        return renderMetaObject(MetaObjectRenderContext.byConfig(metaObjectRender.getType(), config));
    }

    /**
     * 根据元对象渲染上下文进行处理渲染。
     *
     * @param context 元对象渲染上下文
     * @return cn.zeroable.cat4j.base.vo.MetaObjectRenderVO 元对象渲染VO
     * @throws cn.zeroable.cat4j.core.exception.BiException 当渲染失败是抛出
     * @author zeroable
     * @date 2024/6/16 18:33
     */
    protected abstract MetaObjectRenderVO renderMetaObject(MetaObjectRenderContext<T> context);

    /**
     * 获取配置类Class。
     *
     * @return java.lang.Class<T>
     * @author zeroable
     * @date 2024/6/16 18:34
     */
    protected Class<T> getConfigClass() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}
