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
import cn.zeroable.cat4j.base.entity.RolePO;
import cn.zeroable.cat4j.base.service.RoleService;

import java.util.Arrays;

/**
 * 角色表 接口
 *
 * @author zeroable
 * @version 2023-12-27 21:34:21
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/role")
@AllArgsConstructor
@Slf4j
public class RoleController {
    private RoleService roleService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return ApiResult<RolePO>  实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @GetMapping("{id}")
    public ApiResult<RolePO> detail(@PathVariable String id) {
        RolePO detail = roleService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param role  筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage < RolePO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @GetMapping
    public ApiResult<IPage<RolePO>> pageQuery(RolePO role, Query query) {
        QueryWrapper<RolePO> queryWrapper = Condition.getQueryWrapper(role);
        IPage<RolePO> pages = roleService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return ApiResult<RolePO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @PostMapping
    public ApiResult<RolePO> add(@RequestBody @Validated(Add.class) RolePO role) {
        roleService.save(role);
        return ApiResult.ok();
    }

    /**
     * 更新数据
     *
     * @param role 实例对象
     * @return ApiResult<RolePO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @PutMapping
    public ApiResult<RolePO> edit(@RequestBody @Validated(Update.class) RolePO role) {
        roleService.updateById(role);
        return ApiResult.ok();
    }

    /**
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @DeleteMapping
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(roleService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}