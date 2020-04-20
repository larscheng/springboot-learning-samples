package com.larscheng.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: larscheng
 * @date: 2020/4/20 下午2:26
 * @description:
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver(){
        return new I18nLocaleResolver();
    }
}
