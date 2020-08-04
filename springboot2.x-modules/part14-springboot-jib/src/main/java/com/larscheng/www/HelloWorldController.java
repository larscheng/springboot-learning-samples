package com.larscheng.www;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author: larscheng
 * @date: 2020/4/29 下午7:50
 * @description:
 */
@RestController
public class HelloWorldController {

    @PostMapping("/event/push")
    public String push(@RequestBody String msg){
        System.out.println("----------------"+ LocalDateTime.now() +"------------------");
        System.out.println(msg);
        return "ok";
    }
}
