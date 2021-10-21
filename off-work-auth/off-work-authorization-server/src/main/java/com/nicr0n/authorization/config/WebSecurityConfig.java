package com.nicr0n.authorization.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: Nicr0n
 * @date: 2021/10/21    16:42
 * @email: Nicr0nFF@gmail.com
 */
@Configuration
@Slf4j
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 密码模式下必须注入的bean authenticationManagerBean
     * 认证是由 AuthenticationManager 来管理的，
     * 但是真正进行认证的是 AuthenticationManager 中定义的AuthenticationProvider。
     *  AuthenticationManager 中可以定义有多个 AuthenticationProvider
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
