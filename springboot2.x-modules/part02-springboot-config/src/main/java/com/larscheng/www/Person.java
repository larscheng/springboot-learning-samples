package com.larscheng.www;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: larscheng
 * @date: 2020/4/18 下午2:23
 * @description: ConfigurationProperties批量注入配置（默认是application.properties）
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;

    private int age;
}
