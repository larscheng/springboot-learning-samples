package com.larscheng.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Part01SpringbootHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(Part01SpringbootHelloworldApplication.class, args);
    }

    @RequestMapping("/test")
    public String test(){
        return "hello world!!";
    }
}
