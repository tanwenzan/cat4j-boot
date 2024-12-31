package cn.zeroable.cat4j.base.service.metaobject;

import cn.zeroable.cat4j.base.dto.MetaObjectRenderDTO;
import cn.zeroable.cat4j.base.vo.MetaObjectRenderVO;
import cn.zeroable.cat4j.core.factory.Type;

/**
 * 元数据创建器 接口.
 * <br/> 根据不同类型来创建元数据，可以根据数据库来创建、也可以根据json 来创建.
 *
 * @author tanwenzan
 * @version 2024/6/12 17:09
 * @since 0.0.1
 */
public interface IMetaObjectCreator extends Type<MetaObjectCreateType> {

    /**
     * 渲染元对象VO。
     * <br/> 根据配置信息渲染元对象数据
     *
     * @param metaObjectRender 元对象渲染DTO
     * @return cn.zeroable.cat4j.base.vo.MetaObjectRenderVO 元对象渲染 View Object
     * @throws cn.zeroable.cat4j.core.exception.BiException 渲染出错时抛出
     * @author zeroable
     * @date 2024/6/16 18:09
     */
    MetaObjectRenderVO renderMetaObject(MetaObjectRenderDTO metaObjectRender);


}
