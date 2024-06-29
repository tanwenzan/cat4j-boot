package cn.zeroable.cat4j.base.service.metaobject;

import cn.zeroable.cat4j.core.factory.AbstractObjectFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 元对象创建器 工厂。
 *
 * @author zeroable
 * @version 2024/6/16 18:38
 * @since 0.0.1
 */
@Component
public class MetaObjectCreatorFactory extends AbstractObjectFactory<IMetaObjectCreator, MetaObjectCreateType> {

    public MetaObjectCreatorFactory(Map<String, IMetaObjectCreator> beansOfType) {
        super(beansOfType);
    }

}
