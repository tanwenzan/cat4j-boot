package cn.zeroable.cat4j.base.controller;

import cn.zeroable.cat4j.base.dto.MetaObjectAddDTO;
import cn.zeroable.cat4j.base.vo.TableInfoVO;
import cn.zeroable.cat4j.core.DataSourceManager;
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
import cn.zeroable.cat4j.base.entity.MetaObjectEntity;
import cn.zeroable.cat4j.base.service.MetaObjectService;

import java.util.Arrays;
import java.util.List;

/**
 * 元对象 接口
 *
 * @author zeroable
 * @version 2024-03-01 11:06:11
 * @since 0.0.1
 */
@RestController
@RequestMapping("/metaObject")
@AllArgsConstructor
@Slf4j
public class MetaObjectController {

    private MetaObjectService metaObjectService;

    private DataSourceManager dataSourceManager;

    /**
     * 通过ID查询单条数据明细信息
     *
     * @param id 主键
     * @return ApiResult<MetaObjectEntity>  实例对象
     * @author zeroable
     * @date 2024-03-01 11:06:11
     */
    @GetMapping("{id}")
    public ApiResult<MetaObjectEntity> detail(@PathVariable String id) {
        MetaObjectEntity detail = metaObjectService.getById(id);
        return ApiResult.ok(detail);
    }

    /**
     * 分页查询
     *
     * @param metaObject 筛选条件
     * @param query      分页对象
     * @return ApiResult<IPage < MetaObjectEntity>> 查询结果
     * @author zeroable
     * @date 2024-03-01 11:06:11
     */
    @GetMapping
    public ApiResult<IPage<MetaObjectEntity>> pageQuery(@RequestParam MetaObjectEntity metaObject, Query query) {
        QueryWrapper<MetaObjectEntity> queryWrapper = Condition.getQueryWrapper(metaObject);
        IPage<MetaObjectEntity> pages = metaObjectService.page(Condition.getPage(query), queryWrapper);
        return ApiResult.ok(pages);
    }

    /**
     * 获取数据库表信息列表接口。
     *
     * @param tableName 表名称
     * @return cn.zeroable.cat4j.core.ApiResult<java.util.List < cn.zeroable.cat4j.base.vo.TableInfoVO>>
     * @author zeroable
     * @date 2024/4/2 10:14
     */
    @GetMapping("table-list")
    public ApiResult<IPage<TableInfoVO>> tableList(@RequestParam(value = "tableName", name = "tableName",
            required = false) String tableName, Query query) {
        IPage<TableInfoVO> tableList = metaObjectService.tableList(tableName, query);
        return ApiResult.ok(tableList);
    }

    /**
     * 新增元对象
     *
     * @param metaObject 实例对象
     * @return ApiResult<MetaObjectEntity> 实例对象
     * @author zeroable
     * @date 2024-03-01 11:06:11
     */
    @PostMapping
    public ApiResult<Boolean> add(@RequestBody @Validated MetaObjectAddDTO metaObject) {
        metaObjectService.addMetaObject(metaObject);
        return ApiResult.ok();
    }

    /**
     * 更新元对象数据
     *
     * @param metaObject 实例对象
     * @return ApiResult<MetaObjectEntity> 实例对象
     * @author zeroable
     * @date 2024-03-01 11:06:11
     */
    @PutMapping
    public ApiResult<MetaObjectEntity> edit(@RequestBody @Validated(Update.class) MetaObjectEntity metaObject) {
        metaObjectService.updateById(metaObject);
        return ApiResult.ok();
    }

    /**
     * 通过主键删除数据
     *
     * @param baseDelete 主键
     * @return ApiResult<Boolean> 是否成功
     * @author zeroable
     * @date 2024-03-01 11:06:11
     */
    @DeleteMapping
    public ApiResult<Boolean> deleteById(@RequestBody @Validated BaseDeleteDTO baseDelete) {
        return ApiResult.ok(metaObjectService.removeByIds(Arrays.asList(ArrayUtil.toStrArray(baseDelete.getIds()))));
    }

    @GetMapping("/datasource-list")
    public ApiResult<List<String>> datasourceList() {
        return ApiResult.ok(dataSourceManager.getDatasourceNames());
    }
}