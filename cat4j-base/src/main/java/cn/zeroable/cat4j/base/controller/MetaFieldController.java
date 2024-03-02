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
import cn.zeroable.cat4j.base.entity.MetaFieldEntity;
import cn.zeroable.cat4j.base.service.MetaFieldService;

import java.util.Arrays;
 /**
 * 元字段 接口
 *
 * @author zeroable
 * @version 2024-03-01 11:07:11
 * @since 0.0.1
 */
@RestController
@RequestMapping("/metaField")
@AllArgsConstructor
@Slf4j
public class MetaFieldController {
    private MetaFieldService metaFieldService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return ApiResult<MetaFieldEntity>  实例对象
     * @author zeroable
     * @date 2024-03-01 11:07:11
     */
    @GetMapping("{id}")
    public ApiResult<MetaFieldEntity> detail(@PathVariable String id) {
        MetaFieldEntity detail = metaFieldService.getById(id);
        return ApiResult.ok(detail);
    }
    
    /** 
     * 分页查询
     *
     * @param metaField 筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage<MetaFieldEntity>> 查询结果
     * @author zeroable
     * @date 2024-03-01 11:07:11
     */
    @GetMapping
    public ApiResult<IPage<MetaFieldEntity>> pageQuery(@RequestParam MetaFieldEntity metaField, Query query) {
        QueryWrapper<MetaFieldEntity> queryWrapper = Condition.getQueryWrapper(metaField);
		IPage<MetaFieldEntity> pages = metaFieldService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }
    
    /** 
     * 新增数据
     *
     * @param metaField 实例对象
     * @return ApiResult<MetaFieldEntity> 实例对象
     * @author zeroable
     * @date 2024-03-01 11:07:11
     */
    @PostMapping
    public ApiResult<MetaFieldEntity> add(@RequestBody @Validated(Add.class) MetaFieldEntity metaField) {
        metaFieldService.save(metaField);
        return ApiResult.ok();
    }
    
    /** 
     * 更新数据
     *
     * @param metaField 实例对象
     * @return ApiResult<MetaFieldEntity> 实例对象
     * @author zeroable
     * @date 2024-03-01 11:07:11
     */
    @PutMapping
    public ApiResult<MetaFieldEntity> edit(@RequestBody @Validated(Update.class) MetaFieldEntity metaField) {
        metaFieldService.updateById(metaField);
        return ApiResult.ok();
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2024-03-01 11:07:11
     */
    @DeleteMapping
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(metaFieldService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}