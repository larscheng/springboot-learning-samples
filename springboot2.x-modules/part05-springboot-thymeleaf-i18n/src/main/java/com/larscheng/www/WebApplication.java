package com.larscheng.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.Arrays;

/**
 * @author: larscheng
 * @date: 2020/4/20 上午10:49
 * @description:
 */
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


    @Controller
    static class TestController {

        @RequestMapping({"/index", "/"})
        public String index() {
            return "index";
        }

        @Autowired
        private MessageSource messageSource;

        @GetMapping({"/login"})
        public String index(Model model, String username, String password) {
            if (username.equals("admin") && password.equals("admin")) {

                model.addAttribute("msg",
                        messageSource.getMessage("login.success", null, LocaleContextHolder.getLocale()));
            } else {
                model.addAttribute("msg",
                        messageSource.getMessage("login.error", null, LocaleContextHolder.getLocale()));
            }
            return "result";
        }

    }
}
