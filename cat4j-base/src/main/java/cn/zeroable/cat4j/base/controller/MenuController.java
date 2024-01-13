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
import cn.zeroable.cat4j.base.po.Menu;
import cn.zeroable.cat4j.base.service.MenuService;

import java.util.Arrays;
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
    public ApiResult<Menu> detail(@PathVariable String id) {
        Menu detail = menuService.getById(id);
        return ApiResult.ok(detail);
    }
    
    /** 
     * 分页查询
     *
     * @param menu 筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage<MenuPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:07:21
     */
    @GetMapping
    public ApiResult<IPage<Menu>> pageQuery(Menu menu, Query query) {
        QueryWrapper<Menu> queryWrapper = Condition.getQueryWrapper(menu);
		IPage<Menu> pages = menuService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
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
    public ApiResult<Menu> add(@RequestBody @Validated(Add.class) Menu menu) {
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
    public ApiResult<Menu> edit(@RequestBody @Validated(Update.class) Menu menu) {
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
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(menuService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}