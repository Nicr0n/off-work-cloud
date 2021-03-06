package com.nicr0n.testconsumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author: Nicr0n
 * @date: 2021/10/28    16:20
 * @email: Nicr0nFF@gmail.com
 */
@Configuration
// 启动资源服务器
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "test";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 不需要授权认证的
                .antMatchers("/hi",
                        "/swagger-resources/**",
                        "/v2/**",
                        "/webjars/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
