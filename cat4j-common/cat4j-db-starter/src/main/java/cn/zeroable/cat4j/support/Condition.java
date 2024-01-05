package cn.zeroable.cat4j.support;

import cn.hutool.core.util.ReflectUtil;
import cn.zeroable.cat4j.core.util.ArrayUtil;
import cn.zeroable.cat4j.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具.
 *
 * @author zeroable
 * @version 2023/8/18 10:20
 * @since 0.0.1
 */
public class Condition {
    /**
     * 转化成mybatis plus中的Page
     *
     * @param query 查询条件
     * @return IPage
     * @author zeroable
     * @date 2023/8/18 11:14
     */
    public static <T> IPage<T> getPage(Query query) {
        Page<T> page = new Page<>(NumberUtil.toInt(query.getCurrent(), 1), NumberUtil.toInt(query.getSize(), 10));
        String[] ascArr = ArrayUtil.toStrArray(query.getAsc());
        for (String asc : ascArr) {
            page.addOrder(OrderItem.asc(cleanIdentifier(asc)));
        }
        String[] descArr = ArrayUtil.toStrArray(query.getDesc());
        for (String desc : descArr) {
            page.addOrder(OrderItem.desc(cleanIdentifier(desc)));
        }
        return page;
    }

    /**
     * 获取标识符，用于参数清理。
     *
     * @param param 参数
     * @return java.lang.String 清理后的标识符
     * @author zeroable
     * @date 2023/8/18 11:14
     */
    @Nullable
    public static String cleanIdentifier(@Nullable String param) {
        if (param == null) {
            return null;
        }
        StringBuilder paramBuilder = new StringBuilder();
        for (int i = 0; i < param.length(); i++) {
            char c = param.charAt(i);
            if (Character.isJavaIdentifierPart(c)) {
                paramBuilder.append(c);
            }
        }
        return paramBuilder.toString();
    }

    /**
     * 获取mybatis plus中的QueryWrapper。
     *
     * @param entity 实体
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<T>
     * @author zeroable
     * @date 2023/8/18 11:16
     */
    public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
        return new QueryWrapper<>(entity);
    }

    /**
     * 获取mybatis plus中的QueryWrapper
     *
     * @param query 查询条件
     * @param clazz 实体类
     * @param <T>   类型
     * @return QueryWrapper
     */
    public static <T> QueryWrapper<T> getQueryWrapper(Map<String, Object> query, Class<T> clazz) {
        Map<String, Object> exclude = new HashMap<>();
        exclude.put("current", "current");
        exclude.put("size", "size");
        exclude.put("asc", "asc");
        exclude.put("desc", "desc");
        return getQueryWrapper(query, exclude, clazz);
    }

    /**
     * 获取mybatis plus中的QueryWrapper
     *
     * @param query   查询条件
     * @param exclude 排除的查询条件
     * @param clazz   实体类
     * @param <T>     类型
     * @return QueryWrapper
     */
    public static <T> QueryWrapper<T> getQueryWrapper(Map<String, Object> query, Map<String, Object> exclude, Class<T> clazz) {
        exclude.forEach((k, v) -> query.remove(k));
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.setEntity(ReflectUtil.newInstance(clazz));
        SqlKeyword.buildCondition(query, qw);
        return qw;
    }
}
