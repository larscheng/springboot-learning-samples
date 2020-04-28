package com.larscheng.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: larscheng
 * @date: 2020/4/28 上午9:59
 * @description:
 */
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/api")
    public String api() {
        return "Springboot security api";
    }



    @GetMapping("/add")
    public String add() {
        return "add success";
    }


    @GetMapping("/del")
    public String del() {
        return "delete success";
    }
}
