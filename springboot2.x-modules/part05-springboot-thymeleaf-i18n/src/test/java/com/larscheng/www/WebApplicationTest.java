package com.larscheng.www;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class WebApplicationTest {


    @Autowired
    private HelloService helloService;
    @Test
    public void test(){
        System.out.println(helloService.sayHello());
        helloService.setMsg("lalallalalallal");

        System.out.println(helloService.sayHello());
    }
}