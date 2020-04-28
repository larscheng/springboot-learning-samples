package com.larscheng.www.ip;

import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: larscheng
 * @date: 2020/4/28 下午7:25
 * @description: 一个ip登录次数的处理逻辑
 */

@Service
public class LoginAttemptService {

    /*同一ip最大重试次数*/
    private final static Integer MAX_TIMES = 2;

    /*某一个ip的重试登录次数*/
    private Map<String, Integer> loginCacheMap = new HashMap<>(16);

    public LoginAttemptService() {
    }


    public void loginSuccess(String ip) {
        loginCacheMap.put(ip, 0);
    }

    public void loginFault(String ip) {
        Integer time = Optional.ofNullable(loginCacheMap.get(ip)).orElse(0);
        time++;
        loginCacheMap.put(ip, time);
    }


    public boolean isBlock(String ip) {
        Integer time = Optional.ofNullable(loginCacheMap.get(ip)).orElse(0);
        return time > MAX_TIMES;
    }
}
