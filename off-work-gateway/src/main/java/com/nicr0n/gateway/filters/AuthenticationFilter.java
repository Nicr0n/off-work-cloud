package com.nicr0n.gateway.filters;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.nicr0n.gateway.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

/**
 * @author: Nicr0n
 * @date: 2021/10/29    17:19
 * @email: Nicr0nFF@gmail.com
 */
@Slf4j
@Component
public class AuthenticationFilter implements Ordered, GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 从请求头部中获取authentication参数
        ServerHttpRequest request = exchange.getRequest();
        String authentication = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String method = request.getMethodValue();
        String url = request.getPath().value();
        log.debug("url:{},method:{},headers:{}", url, method, request.getHeaders());

        // 过滤器初始化时Bean还未注册到Spring容器中 需要在方法中通过context获取Bean
        AuthenticationService authenticationService = SpringUtil.getBean(AuthenticationService.class);
        try {
            if (!authenticationService.checkToken(authentication)) {
                log.info("登录凭证校验失败！");
                return unauthorized(exchange.getResponse(), "登录凭证校验失败！");
            }
            JWT jwt = JWTUtil.parseToken(authentication);
            // jwt中默认保存位数少3位 补0
            if (Long.parseLong(jwt.getPayload().getClaim("exp").toString()+"000") < new Date().getTime()) {
                System.out.println(Long.parseLong(jwt.getPayload().getClaim("exp").toString()));
                System.out.println(new Date().getTime());
                log.info("登录凭证已过期！");
                return unauthorized(exchange.getResponse(), "登录凭证已过期！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return unauthorized(exchange.getResponse(), "登录凭证校验失败！");
        }
        log.info("登录校验成功！");
        return chain.filter(exchange);
    }

    private Mono<Void> unauthorized(ServerHttpResponse response, String msg) {

        // 放入json对象
        JSONObject message = new JSONObject();
        message.set("status_flag", false);
        message.set("code", HttpStatus.HTTP_UNAUTHORIZED);
        message.set("message", msg);
        message.set("time", Instant.now());
        DataBuffer buffer = response.bufferFactory().wrap(message.toString().getBytes(StandardCharsets.UTF_8));

        //指定编码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
