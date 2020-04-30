package com.larscheng.www.web;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.larscheng.www.config.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: larscheng
 * @date: 2020/4/29 下午7:50
 * @description:
 */
@RestController
@ApiSort(300)
@Api(value = "HelloWorld测试",tags = "Tag-hello")
public class HelloWorldController {

    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @GetMapping("/hello")
    public Message hello(){
        return new Message().setData("hello");
    }
}
