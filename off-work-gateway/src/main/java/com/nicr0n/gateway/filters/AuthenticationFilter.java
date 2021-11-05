package com.nicr0n.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author: Nicr0n
 * @date: 2021/10/29    17:19
 * @email: Nicr0nFF@gmail.com
 */
@Slf4j
@Component
public class AuthenticationFilter implements Ordered,GatewayFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 从请求头部中获取authentication参数
        ServerHttpRequest request = exchange.getRequest();
        String authentication = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String method = request.getMethodValue();
        String url = request.getPath().value();
        log.debug("url:{},method:{},headers:{}", url, method, request.getHeaders());

        System.out.println(authentication);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
