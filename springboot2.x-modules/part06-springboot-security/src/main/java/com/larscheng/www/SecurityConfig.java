package com.larscheng.www;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author: larscheng
 * @date: 2020/4/28 上午10:29
 * @description:
 */
@Configuration
public class   SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //粗粒度 hasAnyRole
                .antMatchers(HttpMethod.GET,"/log**").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.GET,"/adm**").hasRole("ADMIN")
                //细粒度 hasAnyAuthority
                .antMatchers(HttpMethod.GET,"/add**").hasAnyAuthority("read")
                .antMatchers(HttpMethod.GET,"/del**").hasAnyAuthority("delete")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/loginPageCustom")
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/logoutPageCustom")
                .permitAll();
    }

    @Bean
    public static PasswordEncoder myEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService UserDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("admin")
                .password(myEncoder().encode("123456"))
                .roles("ADMIN")
                .authorities("read","delete")
                .build()
        );
        manager.createUser(
                User.withUsername("test")
                .password(myEncoder().encode("123456"))
                .roles("USER")
                .authorities("read")
                .build()
        );
        manager.createUser(
                User.withUsername("guest")
                        .password(myEncoder().encode("123456"))
                        .roles("GUEST")
                        .build()
        );
        return manager;
    }
}
