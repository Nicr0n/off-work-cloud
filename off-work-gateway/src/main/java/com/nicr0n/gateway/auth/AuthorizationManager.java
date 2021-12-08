package com.nicr0n.gateway.auth;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Nicr0n
 * @date: 2021/12/8    15:27
 * @email: Nicr0nFF@gmail.com
 */
@Component
@Slf4j
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authenticationMono, AuthorizationContext authorizationContext) {
        // 获取请求主体
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();

        // 获取请求路径
        String path = request.getURI().getPath();

        // 跨域预检请求直接放行
        if (request.getMethod()== HttpMethod.OPTIONS){
            return Mono.just(new AuthorizationDecision(true));
        }

        authenticationMono.map(authentication -> {
            Jwt principal = (Jwt) authentication.getPrincipal();
            log.info("{}",principal);
            return principal;
        });

        // token为空直接拒绝
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StrUtil.isBlankIfStr(token)){
            return Mono.just(new AuthorizationDecision(false));
        }

        Set<String> authorities = new HashSet<>();

        Mono<AuthorizationDecision> authorizationDecisionMono = authenticationMono
                // 过滤未验证
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(roleID->{
                    log.info("访问路径：{}",path);
                    log.info("用户的角色id：{}",roleID);
                    log.info("资源需要的权限：{}",authorities);
                    return authorities.contains(roleID);
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
            return authorizationDecisionMono;
    }
}
