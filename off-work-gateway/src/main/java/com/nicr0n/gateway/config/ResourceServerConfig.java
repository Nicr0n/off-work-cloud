package com.nicr0n.gateway.config;

import cn.hutool.core.convert.Convert;
import com.nicr0n.gateway.auth.AuthorizationManager;
import com.nicr0n.gateway.handler.CustomAuthenticationEntryPoint;
import com.nicr0n.gateway.handler.CustomDeniedHandler;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2021/12/8    15:43
 * @email: Nicr0nFF@gmail.com
 */
@EnableWebFluxSecurity
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.security")
public class ResourceServerConfig {

    private AuthorizationManager authorizationManager;

    @Setter
    private List<String> whitelist;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtConverter());
        http.oauth2ResourceServer()
                .authenticationEntryPoint(serverAuthenticationEntryPoint())
                .accessDeniedHandler(serverAccessDeniedHandler());
        http.authorizeExchange()
                .pathMatchers(Convert.toStrArray(whitelist)).permitAll()
                .anyExchange().access(authorizationManager);
        http.csrf().disable();
        return http.build();
    }

    @Bean
    ServerAuthenticationEntryPoint serverAuthenticationEntryPoint(){
        return new CustomAuthenticationEntryPoint();
    }

    @Bean
    ServerAccessDeniedHandler serverAccessDeniedHandler(){
        return new CustomDeniedHandler();
    }


    @Bean
    public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtConverter(){
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }
}
