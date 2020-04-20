package com.larscheng.www;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: larscheng
 * @date: 2020/4/18 下午2:23
 * @description:
 * ConfigurationProperties批量注入配置
 * PropertySource指定classpath下的某一个配置文件
 */
@Data
@Component
@PropertySource(value = "classpath:student.properties")
@ConfigurationProperties(prefix = "student")
public class Student {

    private String name;

    private int age;
}
