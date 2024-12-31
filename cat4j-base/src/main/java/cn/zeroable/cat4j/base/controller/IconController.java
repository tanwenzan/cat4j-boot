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
import cn.zeroable.cat4j.base.entity.IconEntity;
import cn.zeroable.cat4j.base.service.IconService;

import java.util.Arrays;
 /**
 * 图标表 接口
 *
 * @author zeroable
 * @version 2024-02-07 10:08:10
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/common/icon")
@AllArgsConstructor
@Slf4j
public class IconController {
    private IconService iconService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return ApiResult<IconEntity>  实例对象
     * @author zeroable
     * @date 2024-02-07 10:08:10
     */
    @GetMapping("{id}")
    public ApiResult<IconEntity> detail(@PathVariable String id) {
        IconEntity detail = iconService.getById(id);
        return ApiResult.ok(detail);
    }
    
    /** 
     * 分页查询
     *
     * @param icon 筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage<IconEntity>> 查询结果
     * @author zeroable
     * @date 2024-02-07 10:08:10
     */
    @GetMapping
    public ApiResult<IPage<IconEntity>> pageQuery(@RequestParam IconEntity icon, Query query) {
        QueryWrapper<IconEntity> queryWrapper = Condition.getQueryWrapper(icon);
		IPage<IconEntity> pages = iconService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }
    
    /** 
     * 新增数据
     *
     * @param icon 实例对象
     * @return ApiResult<IconEntity> 实例对象
     * @author zeroable
     * @date 2024-02-07 10:08:10
     */
    @PostMapping
    public ApiResult<IconEntity> add(@RequestBody @Validated(Add.class) IconEntity icon) {
        iconService.save(icon);
        return ApiResult.ok();
    }
    
    /** 
     * 更新数据
     *
     * @param icon 实例对象
     * @return ApiResult<IconEntity> 实例对象
     * @author zeroable
     * @date 2024-02-07 10:08:10
     */
    @PutMapping
    public ApiResult<IconEntity> edit(@RequestBody @Validated(Update.class) IconEntity icon) {
        iconService.updateById(icon);
        return ApiResult.ok();
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2024-02-07 10:08:10
     */
    @DeleteMapping
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(iconService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}