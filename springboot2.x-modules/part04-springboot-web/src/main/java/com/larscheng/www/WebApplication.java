package com.larscheng.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @author: larscheng
 * @date: 2020/4/20 上午10:49
 * @description:
 */
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }



    @Controller
    static class TestController{

        @RequestMapping("/test")
        public String test(Model model){
            model.addAttribute("msg","hahahahhahahahahaq");
            model.addAttribute("users", Arrays.asList("qqqqqqqqq","wwwwwwwww"));
            return "test";
        }
    }
}
