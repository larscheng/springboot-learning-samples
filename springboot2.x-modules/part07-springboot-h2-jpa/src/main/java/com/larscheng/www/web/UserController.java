package com.larscheng.www.web;

import com.larscheng.www.pojo.User;
import com.larscheng.www.repo.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author: larscheng
 * @date: 2020/4/28 下午2:58
 * @description:
 */
@RestController
public class UserController {
    @Autowired
    private UserRep userRep;

    @GetMapping("/list")
    public List<User> getList(){
        return userRep.findAll();
    }

    @GetMapping("/saveAndUpdate")
    public void saveAndUpdate(){
        User user = new User(UUID.randomUUID().toString().substring(0, 5));
        userRep.save(user);
    }

    @GetMapping("/del")
    public void del(Long id){
        userRep.delete(new User(id));
    }
}
