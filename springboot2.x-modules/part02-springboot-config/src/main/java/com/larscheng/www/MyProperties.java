package com.larscheng.www;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: larscheng
 * @date: 2020/4/18 下午2:23
 * @description:
 * ConfigurationProperties批量注入配置
 * yml注入复杂属性
 */
@Data
@Component
@ConfigurationProperties(prefix = "my.config")
public class MyProperties {

    private String url;

    private int port;

    private List<String> user;

    private Map<String,String> password;



}
