package cn.zeroable.cat4j.base.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import cn.zeroable.cat4j.base.entity.MenuEntity;
import cn.zeroable.cat4j.base.service.MenuService;
import cn.zeroable.cat4j.base.vo.MenuVO;
import cn.zeroable.cat4j.base.vo.RouterInfo;
import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.core.util.ArrayUtil;
import cn.zeroable.cat4j.core.validation.Add;
import cn.zeroable.cat4j.core.validation.Update;
import cn.zeroable.cat4j.dto.BaseDeleteDTO;
import cn.zeroable.cat4j.support.Condition;
import cn.zeroable.cat4j.support.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 菜单表 接口
 *
 * @author zeroable
 * @version 2023-12-27 21:07:21
 * @since 0.0.1
 */
@RestController
@RequestMapping("/menu")
@AllArgsConstructor
@Slf4j
public class MenuController {

    private MenuService menuService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return ApiResult<MenuPO>  实例对象
     * @author zeroable
     * @date 2023-12-27 21:07:21
     */
    @GetMapping("{id}")
    @SaCheckPermission("menu.detail")
    public ApiResult<MenuEntity> detail(@PathVariable String id) {
        MenuEntity detail = menuService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param menu  筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage < MenuPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:07:21
     */
    @GetMapping
    @SaCheckPermission("menu.view")
    public ApiResult<IPage<MenuVO>> pageQuery(MenuEntity menu, Query query) {
        return ApiResult.ok(menuService.page(menu, query));
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return ApiResult<MenuPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:07:21
     */
    @PostMapping
    @SaCheckPermission("menu.add")
    public ApiResult<MenuEntity> add(@RequestBody @Validated(Add.class) MenuEntity menu) {
        menuService.save(menu);
        return ApiResult.ok();
    }

    /**
     * 更新数据
     *
     * @param menu 实例对象
     * @return ApiResult<MenuPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:07:21
     */
    @PutMapping
    @SaCheckPermission("menu.edit")
    public ApiResult<MenuEntity> edit(@RequestBody @Validated(Update.class) MenuEntity menu) {
        menuService.updateById(menu);
        return ApiResult.ok();
    }

    /**
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2023-12-27 21:07:21
     */
    @DeleteMapping
    @SaCheckPermission("menu.delete")
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(menuService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }

    @GetMapping("router")
    public ApiResult<List<RouterInfo>> getRouters() {
        // 获取当前用户id
        String loginIdStr = String.valueOf(StpUtil.getLoginId());
        return ApiResult.ok(menuService.getRouterByUserId(Long.valueOf(loginIdStr)));
    }
}