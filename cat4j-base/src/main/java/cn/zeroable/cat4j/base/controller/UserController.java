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
import cn.zeroable.cat4j.base.entity.UserPO;
import cn.zeroable.cat4j.base.service.UserService;

import java.util.Arrays;

/**
 * 用户表 接口
 *
 * @author zeroable
 * @version 2023-12-27 21:34:21
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserService userService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return ApiResult<UserPO>  实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @GetMapping("{id}")
    public ApiResult<UserPO> detail(@PathVariable String id) {
        UserPO detail = userService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param user  筛选条件
     * @param query 分页对象
     * @return ApiResult<IPage < UserPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @GetMapping
    public ApiResult<IPage<UserPO>> pageQuery(@RequestParam UserPO user, Query query) {
        QueryWrapper<UserPO> queryWrapper = Condition.getQueryWrapper(user);
        IPage<UserPO> pages = userService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return ApiResult<UserPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @PostMapping
    public ApiResult<UserPO> add(@RequestBody @Validated(Add.class) UserPO user) {
        userService.save(user);
        return ApiResult.ok();
    }

    /**
     * 更新数据
     *
     * @param user 实例对象
     * @return ApiResult<UserPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:34:21
     */
    @PutMapping
    public ApiResult<UserPO> edit(@RequestBody @Validated(Update.class) UserPO user) {
        userService.updateById(user);
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
        return ApiResult.ok(userService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}