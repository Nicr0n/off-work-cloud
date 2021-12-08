//package com.nicr0n.gateway.filters;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author: Nicr0n
// * @date: 2021/11/5    16:43
// * @email: Nicr0nFF@gmail.com
// *
// * 初始化FilterFactory并注入到Spring容器中
// */
//@Component
//@Slf4j
//public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {
//
//
//    public AuthenticationGatewayFilterFactory() {
//        super(AuthenticationGatewayFilterFactory.Config.class);
//        log.info("加载过滤器[Authentication]");
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return new AuthenticationFilter();
//    }
//
//    @Data
//    public static class Config{
//        private String name;
//    }
//}
