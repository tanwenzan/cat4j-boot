package cn.zeroable.cat4j.base.controller;

import cn.zeroable.cat4j.base.entity.DictItemEntity;
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
@RequestMapping("/dict-item")
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
    public ApiResult<DictItemEntity> detail(@PathVariable String id) {
        DictItemEntity detail = dictItemService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param DictItemEntity 筛选条件
     * @param query    分页对象
     * @return ApiResult<IPage < DictItemPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @GetMapping
    public ApiResult<IPage<DictItemEntity>> pageQuery(DictItemEntity DictItemEntity, Query query) {
        QueryWrapper<DictItemEntity> queryWrapper = Condition.getQueryWrapper(DictItemEntity);
        IPage<DictItemEntity> pages = dictItemService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }

    /**
     * 新增数据
     *
     * @param DictItemEntity 实例对象
     * @return ApiResult<DictItemPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @PostMapping
    public ApiResult<DictItemEntity> add(@RequestBody @Validated(Add.class) DictItemEntity DictItemEntity) {
        dictItemService.save(DictItemEntity);
        return ApiResult.ok();
    }

    /**
     * 更新数据
     *
     * @param DictItemEntity 实例对象
     * @return ApiResult<DictItemPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @PutMapping
    public ApiResult<DictItemEntity> edit(@RequestBody @Validated(Update.class) DictItemEntity DictItemEntity) {
        dictItemService.updateById(DictItemEntity);
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