package com.larscheng.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: larscheng
 * @date: 2020/4/28 上午9:59
 * @description:
 */
@Controller
public class HelloController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/loginPageCustom")
    public String login() {
        return "login";
    }


    @GetMapping("/logoutPageCustom")
    public String logout() {
        return "logout";
    }

    @GetMapping("/adminPage")
    public String adminPage() {
        return "adminPage";
    }



}
