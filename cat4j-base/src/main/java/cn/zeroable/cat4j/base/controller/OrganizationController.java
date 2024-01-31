package cn.zeroable.cat4j.base.controller;

import cn.zeroable.cat4j.base.entity.OrganizationEntity;
import cn.zeroable.cat4j.base.service.OrganizationService;
import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.core.util.ArrayUtil;
import cn.zeroable.cat4j.core.validation.Add;
import cn.zeroable.cat4j.core.validation.Update;
import cn.zeroable.cat4j.dto.BaseDeleteDTO;
import cn.zeroable.cat4j.support.Condition;
import cn.zeroable.cat4j.support.Query;
import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleCreateTableStatement;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 组织架构 接口
 *
 * @author zeroable
 * @version 2023-12-27 21:32:21
 * @see
 * @since 0.0.1
 */
@RestController
@RequestMapping("/organization")
@AllArgsConstructor
@Slf4j
public class OrganizationController {
    private OrganizationService organizationService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return ApiResult<OrganizationPO>  实例对象
     * @author zeroable
     * @date 2023-12-27 21:32:21
     */
    @GetMapping("{id}")
    public ApiResult<OrganizationEntity> detail(@PathVariable String id) {
        OrganizationEntity detail = organizationService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param organization 筛选条件
     * @param query        分页对象
     * @return ApiResult<IPage < OrganizationPO>> 查询结果
     * @author zeroable
     * @date 2023-12-27 21:32:21
     */
    @GetMapping
    public ApiResult<IPage<OrganizationEntity>> pageQuery(OrganizationEntity organization, Query query) {
        QueryWrapper<OrganizationEntity> queryWrapper = Condition.getQueryWrapper(organization);
        IPage<OrganizationEntity> pages = organizationService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }

    /**
     * 新增数据
     *
     * @param organization 实例对象
     * @return ApiResult<OrganizationPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:32:21
     */
    @PostMapping
    public ApiResult<OrganizationEntity> add(@RequestBody @Validated(Add.class) OrganizationEntity organization) {
        organizationService.save(organization);
        return ApiResult.ok();
    }

    /**
     * 更新数据
     *
     * @param organization 实例对象
     * @return ApiResult<OrganizationPO> 实例对象
     * @author zeroable
     * @date 2023-12-27 21:32:21
     */
    @PutMapping
    public ApiResult<OracleCreateTableStatement.Organization> edit(@RequestBody @Validated(Update.class) OrganizationEntity organization) {
        organizationService.updateById(organization);
        return ApiResult.ok();
    }

    /**
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2023-12-27 21:32:21
     */
    @DeleteMapping
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(organizationService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }
}