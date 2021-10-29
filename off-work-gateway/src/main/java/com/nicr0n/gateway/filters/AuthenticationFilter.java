package com.nicr0n.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author: Nicr0n
 * @date: 2021/10/29    17:19
 * @email: Nicr0nFF@gmail.com
 */
@Slf4j
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory implements Ordered {
    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
