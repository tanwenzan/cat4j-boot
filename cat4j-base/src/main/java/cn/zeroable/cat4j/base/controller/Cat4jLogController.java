package cn.zeroable.cat4j.base.controller;

import cn.zeroable.cat4j.base.po.Cat4jLogPO;
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
import cn.zeroable.cat4j.base.service.Cat4jLogService;

import java.util.Arrays;

/**
 * 系统日志 接口
 *
 * @author zeroable
 * @version 2023-12-27 21:36:21
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/Cat4jLog")
@AllArgsConstructor
@Slf4j
public class Cat4jLogController {
    private Cat4jLogService cat4jLogService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return ApiResult<Cat4jLogPO>  实例对象
     * @author zeroable
     * @date 2023-12-27 21:36:21
     */
    @GetMapping("{id}")
    public ApiResult<Cat4jLogPO> detail(@PathVariable String id) {
        Cat4jLogPO detail = cat4jLogService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param Cat4jLogPO 筛选条件
     * @param query    分页对象
     * @return ApiResult<IPage < Cat4jLogPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:36:21
     */
    @GetMapping
    public ApiResult<IPage<Cat4jLogPO>> pageQuery(Cat4jLogPO Cat4jLogPO, Query query) {
        QueryWrapper<Cat4jLogPO> queryWrapper = Condition.getQueryWrapper(Cat4jLogPO);
        IPage<Cat4jLogPO> pages = cat4jLogService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }

    /**
     * 新增数据
     *
     * @param Cat4jLogPO 实例对象
     * @return ApiResult<Cat4jLogPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:36:21
     */
    @PostMapping
    public ApiResult<Cat4jLogPO> add(@RequestBody @Validated(Add.class) Cat4jLogPO Cat4jLogPO) {
        cat4jLogService.save(Cat4jLogPO);
        return ApiResult.ok();
    }

    /**
     * 更新数据
     *
     * @param Cat4jLogPO 实例对象
     * @return ApiResult<Cat4jLogPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:36:21
     */
    @PutMapping
    public ApiResult<Cat4jLogPO> edit(@RequestBody @Validated(Update.class) Cat4jLogPO Cat4jLogPO) {
        cat4jLogService.updateById(Cat4jLogPO);
        return ApiResult.ok();
    }

    /**
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2023-12-27 21:36:21
     */
    @DeleteMapping
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(cat4jLogService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}