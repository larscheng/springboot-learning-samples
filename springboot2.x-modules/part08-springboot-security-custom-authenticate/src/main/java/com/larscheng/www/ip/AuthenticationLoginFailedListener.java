package com.larscheng.www.ip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * @author: larscheng
 * @date: 2020/4/28 下午7:37
 * @description: 登陆失败后尝试次数累加
 */
@Component
public class AuthenticationLoginFailedListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) event.getAuthentication().getDetails();
        loginAttemptService.loginFault(webAuthenticationDetails.getRemoteAddress());
    }
}
