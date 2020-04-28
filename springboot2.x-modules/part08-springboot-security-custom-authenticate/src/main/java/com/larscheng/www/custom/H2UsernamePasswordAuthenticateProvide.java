package com.larscheng.www.custom;

import com.larscheng.www.ip.LoginAttemptService;
import com.larscheng.www.jpa.User;
import com.larscheng.www.jpa.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: larscheng
 * @date: 2020/4/28 下午3:55
 * @description: 用户名密码来自数据库
 */
@Component
public class H2UsernamePasswordAuthenticateProvide implements AuthenticationProvider {
    /*把请求认证（用户名密码校验来手动自己实现）*/
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRep userRep;
    @Autowired
    private LoginAttemptService loginAttemptService;

    private List<String> ips = new ArrayList<>();

    public H2UsernamePasswordAuthenticateProvide(){
//        ips.add("10.200.0.171");
        ips.add("127.0.0.1");
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
        String remoteAddress = details.getRemoteAddress();
        /* 是否超过最多尝试次数 */
        if (loginAttemptService.isBlock(remoteAddress)){
            throw new BadCredentialsException("你已超出最大重试次数！！！！");
        }
        if (!ips.contains(remoteAddress)){
            throw new BadCredentialsException("你的ip已被禁用 ");
        }
        /*解析传入的账号密码*/
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        //获取数据库中的账号密码[提前在数据库中创建账号]
        User user = userRep.findByName(username).orElseThrow(()->new BadCredentialsException("username not found!"));
        String usernameDb = user.getName();
        /*123456 ------> $2y$12$kLSU07TzBuWLDn9hSb8iy.6Bsc9a8kv4K.kIHpdj3i6/6uK0UZq7y*/
        String passwordDb = user.getPassword();
        //密码是否相同
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
