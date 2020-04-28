package com.larscheng.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: larscheng
 * @date: 2020/4/28 下午3:51
 * @description:
 */
@Controller
public class  HelloController {
    @GetMapping(value = {"/index","/home"})
    public String index() {
        return "index";
    }


}
