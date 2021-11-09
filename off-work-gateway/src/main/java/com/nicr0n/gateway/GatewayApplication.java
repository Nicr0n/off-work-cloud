package com.nicr0n.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: Nicr0n
 * @date: 2021/10/29    10:56
 * @email: Nicr0nFF@gmail.com
 */
// 启动服务发现
@EnableDiscoveryClient
// 启用feign
@EnableFeignClients(basePackages = "com.nicr0n.gateway.service")
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
