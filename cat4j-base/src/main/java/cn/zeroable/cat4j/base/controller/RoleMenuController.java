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
import cn.zeroable.cat4j.base.entity.RoleMenuPO;
import cn.zeroable.cat4j.base.service.RoleMenuService;

import java.util.Arrays;
 /**
 * 角色权限表 接口
 *
 * @author zeroable
 * @version 2023-12-27 21:34:21
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/roleMenu")
@AllArgsConstructor
@Slf4j
public class RoleMenuController {
    private RoleMenuService roleMenuService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return ApiResult<RoleMenuPO>  实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @GetMapping("{id}")
    public ApiResult<RoleMenuPO> detail(@PathVariable String id) {
        RoleMenuPO detail = roleMenuService.getById(id);
        return ApiResult.ok(detail);
    }
    
    /** 
     * 分页查询
     *
     * @param roleMenu 筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage<RoleMenuPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @GetMapping
    public ApiResult<IPage<RoleMenuPO>> pageQuery(@RequestParam RoleMenuPO roleMenu, Query query) {
        QueryWrapper<RoleMenuPO> queryWrapper = Condition.getQueryWrapper(roleMenu);
		IPage<RoleMenuPO> pages = roleMenuService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }
    
    /** 
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return ApiResult<RoleMenuPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @PostMapping
    public ApiResult<RoleMenuPO> add(@RequestBody @Validated(Add.class) RoleMenuPO roleMenu) {
        roleMenuService.save(roleMenu);
        return ApiResult.ok();
    }
    
    /** 
     * 更新数据
     *
     * @param roleMenu 实例对象
     * @return ApiResult<RoleMenuPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @PutMapping
    public ApiResult<RoleMenuPO> edit(@RequestBody @Validated(Update.class) RoleMenuPO roleMenu) {
        roleMenuService.updateById(roleMenu);
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
        return ApiResult.ok(roleMenuService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}