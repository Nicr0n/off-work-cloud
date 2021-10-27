package com.nicr0n.testcostumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author: Nicr0n
 * @date: 2021/10/27    17:16
 * @email: Nicr0nFF@gmail.com
 */
@Configuration
@EnableAuthorizationServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .anyRequest()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
