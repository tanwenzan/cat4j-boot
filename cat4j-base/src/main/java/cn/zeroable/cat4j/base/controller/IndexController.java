package cn.zeroable.cat4j.base.controller;

import cn.zeroable.cat4j.core.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类.
 *
 * @author zeroable
 * @version 12/24/23 10:41 PM
 * @since 0.0.1
 */
@RestController
public class IndexController {

    @RequestMapping("/test")
    public ApiResult<String> test() {
        return ApiResult.ok("good");
    }
}
