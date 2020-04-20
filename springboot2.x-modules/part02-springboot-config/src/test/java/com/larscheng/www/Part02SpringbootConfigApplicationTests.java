package com.larscheng.www;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Part02SpringbootConfigApplicationTests {

    @Autowired
    private Person person;
    @Test
    void test1() {
        System.out.println(person);
    }

    @Autowired
    private Student student;
    @Test
    void test2() {
        System.out.println(student);
    }


    @Autowired
    private StudentValue studentValue;
    @Test
    void test22() {
        System.out.println(studentValue);
    }

    @Autowired
    private MyProperties properties;
    @Test
    void test3() {
        System.out.println(properties);
    }
}
