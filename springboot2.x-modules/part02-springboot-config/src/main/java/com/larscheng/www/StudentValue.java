package com.larscheng.www;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: larscheng
 * @date: 2020/4/18 下午2:23
 * @description:
 * PropertySource指定classpath下的某一个配置文件
 * 使用javaConfig方式单个注入属性
 */
@Data
@Component
//指定配置文件，默认读取application.properties/application.yml
@PropertySource(value = "classpath:student.properties")
public class StudentValue {

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private int age;
}
