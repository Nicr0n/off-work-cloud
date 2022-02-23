package com.nicr0n.gateway.handler;

import cn.hutool.json.JSONUtil;
import com.nicr0n.gateway.entity.vo.Result;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

/**
 * @author: Nicr0n
 * @date: 2022/2/24  0:30
 * @email: Nicr0nFF@gmail.com
 */
@Component
public class CustomAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

	@Override
	public Mono<Void> commence(ServerWebExchange serverWebExchange, AuthenticationException e) {
		ServerHttpResponse response = serverWebExchange.getResponse();
		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		String body= JSONUtil.toJsonStr(Result.unauthorized(e.getMessage()));
		DataBuffer buffer =  response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
		return response.writeWith(Mono.just(buffer));
	}
}
