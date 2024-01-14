package cn.zeroable.cat4j.base.controller;

import cn.zeroable.cat4j.base.po.DictPO;
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
import cn.zeroable.cat4j.base.service.DictService;

import java.util.Arrays;

/**
 * 字典表 接口
 *
 * @author zeroable
 * @version 2023-12-27 21:35:21
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/dict")
@AllArgsConstructor
@Slf4j
public class DictController {
    private DictService dictService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return ApiResult<DictPO>  实例对象
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @GetMapping("{id}")
    public ApiResult<DictPO> detail(@PathVariable String id) {
        DictPO detail = dictService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param DictPO  筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage < DictPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @GetMapping
    public ApiResult<IPage<DictPO>> pageQuery(DictPO DictPO, Query query) {
        QueryWrapper<DictPO> queryWrapper = Condition.getQueryWrapper(DictPO);
        IPage<DictPO> pages = dictService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }

    /**
     * 新增数据
     *
     * @param DictPO 实例对象
     * @return ApiResult<DictPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @PostMapping
    public ApiResult<DictPO> add(@RequestBody @Validated(Add.class) DictPO DictPO) {
        dictService.save(DictPO);
        return ApiResult.ok();
    }

    /**
     * 更新数据
     *
     * @param DictPO 实例对象
     * @return ApiResult<DictPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:35:21
     */
    @PutMapping
    public ApiResult<DictPO> edit(@RequestBody @Validated(Update.class) DictPO DictPO) {
        dictService.updateById(DictPO);
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
        return ApiResult.ok(dictService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}