package cn.zeroable.cat4j.base.controller;

import cn.zeroable.cat4j.base.service.IconService;
import cn.zeroable.cat4j.base.vo.IconVO;
import cn.zeroable.cat4j.core.ApiResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共接口.
 *
 * @author zeroable
 * @version 2024/2/7 10:45
 * @since 0.0.1
 */
@RestController
@RequestMapping("/common")
@AllArgsConstructor
public class CommonController {

    private IconService iconService;

    /**
     * 字符串转数组。
     *
     * @return cn.zeroable.cat4j.core.ApiResult<cn.zeroable.cat4j.base.vo.IconVO> 根据指定的分隔符分割的字符串数组
     * @author zeroable
     * @date 2023/8/18 11:03
     */
    @RequestMapping("icon")
    public ApiResult<IconVO> iconList() {
        return ApiResult.ok(iconService.iconList());
    }

}
