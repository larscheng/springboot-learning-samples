package com.larscheng.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: larscheng
 * @date: 2020/4/29 下午7:30
 * @description:
 */
@SpringBootApplication
public class Knife4jApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(Knife4jApplication.class,args);
    }

}
