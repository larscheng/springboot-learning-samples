package com.larscheng.www.ip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * @author: larscheng
 * @date: 2020/4/28 下午7:37
 * @description: 登陆成功后尝试次数清0
 */
@Component
public class AuthenticationLoginSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {

        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) event.getAuthentication().getDetails();

        loginAttemptService.loginSuccess(webAuthenticationDetails.getRemoteAddress());
    }
}
