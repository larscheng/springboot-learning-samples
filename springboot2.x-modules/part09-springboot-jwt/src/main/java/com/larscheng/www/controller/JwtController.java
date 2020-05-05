package com.larscheng.www.controller;

import com.larscheng.www.entity.Role;
import com.larscheng.www.entity.User;
import com.larscheng.www.entity.UserDto;
import com.larscheng.www.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class JwtController {

    @GetMapping("/api/guest")
    public String guest(){
        return "这是访客接口";
    }


    @GetMapping("/api/admin")
    public String admin(){
        return "这是管理员接口";
    }

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/api/register")
    public boolean register(@RequestBody UserDto dto){
        User user = new User();
        user.setName(dto.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        Role role = new Role();
        role.setName(dto.getRole());
        role.setUsers(Collections.singletonList(user));
        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);

        return true;
    }
}
