package com.larscheng.www.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

/**
 * @author: larscheng
 * @date: 2020/4/28 下午3:55
 * @description:
 */
//@Component
public class MyUsernamePasswordAuthenticateProvide implements AuthenticationProvider {
    /*把请求认证（用户名密码校验来手动自己实现）*/
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        //模拟数据库中的用户名密码
        String usernameDb = "admin";
        /*123456 ------> $2y$12$kLSU07TzBuWLDn9hSb8iy.6Bsc9a8kv4K.kIHpdj3i6/6uK0UZq7y*/
        String passwordDb = "$2y$12$kLSU07TzBuWLDn9hSb8iy.6Bsc9a8kv4K.kIHpdj3i6/6uK0UZq7y";
        boolean isPassword = passwordEncoder.matches(password,passwordDb);
        if (username.equals(usernameDb) && isPassword) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            throw new BadCredentialsException("用户名密码错误");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
