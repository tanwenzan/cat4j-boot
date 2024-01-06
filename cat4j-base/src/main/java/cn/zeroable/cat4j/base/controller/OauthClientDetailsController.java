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
import cn.zeroable.cat4j.base.entity.OauthClientDetailsPO;
import cn.zeroable.cat4j.base.service.OauthClientDetailsService;

import java.util.Arrays;
 /**
 * 终端信息表 接口
 *
 * @author zeroable
 * @version 2024-01-07 000:12:00
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/oauthClientDetails")
@AllArgsConstructor
@Slf4j
public class OauthClientDetailsController {
    private OauthClientDetailsService oauthClientDetailsService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return ApiResult<OauthClientDetailsPO>  实例对象
     * @author zeroable
     * @date 2024-01-07 000:12:00
     */
    @GetMapping("{id}")
    public ApiResult<OauthClientDetailsPO> detail(@PathVariable String id) {
        OauthClientDetailsPO detail = oauthClientDetailsService.getById(id);
        return ApiResult.ok(detail);
    }
    
    /** 
     * 分页查询
     *
     * @param oauthClientDetails 筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage<OauthClientDetailsPO>> 查询结果
     * @author zeroable
     * @date 2024-01-07 000:12:00
     */
    @GetMapping
    public ApiResult<IPage<OauthClientDetailsPO>> pageQuery(@RequestParam OauthClientDetailsPO oauthClientDetails, Query query) {
        QueryWrapper<OauthClientDetailsPO> queryWrapper = Condition.getQueryWrapper(oauthClientDetails);
		IPage<OauthClientDetailsPO> pages = oauthClientDetailsService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }
    
    /** 
     * 新增数据
     *
     * @param oauthClientDetails 实例对象
     * @return ApiResult<OauthClientDetailsPO> 实例对象
     * @author zeroable
     * @date 2024-01-07 000:12:00
     */
    @PostMapping
    public ApiResult<OauthClientDetailsPO> add(@RequestBody @Validated(Add.class) OauthClientDetailsPO oauthClientDetails) {
        oauthClientDetailsService.save(oauthClientDetails);
        return ApiResult.ok();
    }
    
    /** 
     * 更新数据
     *
     * @param oauthClientDetails 实例对象
     * @return ApiResult<OauthClientDetailsPO> 实例对象
     * @author zeroable
     * @date 2024-01-07 000:12:00
     */
    @PutMapping
    public ApiResult<OauthClientDetailsPO> edit(@RequestBody @Validated(Update.class) OauthClientDetailsPO oauthClientDetails) {
        oauthClientDetailsService.updateById(oauthClientDetails);
        return ApiResult.ok();
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2024-01-07 000:12:00
     */
    @DeleteMapping
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(oauthClientDetailsService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}