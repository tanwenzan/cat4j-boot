package cn.zeroable.cat4j.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.zeroable.cat4j.core.validation.Add;
import cn.zeroable.cat4j.core.validation.Update;
import cn.zeroable.cat4j.core.util.ArrayUtil;
import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.dto.BaseDeleteDTO;
import cn.zeroable.cat4j.support.Query;
import cn.zeroable.cat4j.support.Condition;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import cn.zeroable.cat4j.base.po.DictItem;
import cn.zeroable.cat4j.base.service.DictItemService;

import java.util.Arrays;

/**
 * 字典明细 接口
 *
 * @author zeroable
 * @version 2023-12-27 21:35:21
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/dictItem")
@AllArgsConstructor
@Slf4j
public class DictItemController {
    private DictItemService dictItemService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return ApiResult<DictItemPO>  实例对象
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @GetMapping("{id}")
    public ApiResult<DictItem> detail(@PathVariable String id) {
        DictItem detail = dictItemService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param dictItem 筛选条件
     * @param query    分页对象
     * @return ApiResult<IPage < DictItemPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @GetMapping
    public ApiResult<IPage<DictItem>> pageQuery(DictItem dictItem, Query query) {
        QueryWrapper<DictItem> queryWrapper = Condition.getQueryWrapper(dictItem);
        IPage<DictItem> pages = dictItemService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }

    /**
     * 新增数据
     *
     * @param dictItem 实例对象
     * @return ApiResult<DictItemPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @PostMapping
    public ApiResult<DictItem> add(@RequestBody @Validated(Add.class) DictItem dictItem) {
        dictItemService.save(dictItem);
        return ApiResult.ok();
    }

    /**
     * 更新数据
     *
     * @param dictItem 实例对象
     * @return ApiResult<DictItemPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @PutMapping
    public ApiResult<DictItem> edit(@RequestBody @Validated(Update.class) DictItem dictItem) {
        dictItemService.updateById(dictItem);
        return ApiResult.ok();
    }

    /**
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @DeleteMapping
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(dictItemService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}