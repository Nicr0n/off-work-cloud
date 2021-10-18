package com.nicr0n.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: Nicr0n
 * @date: 2021/10/18 17:52
 * @email: Nicr0nFF@gmail.com
 */
// 启动服务发现
@EnableDiscoveryClient

@SpringBootApplication
public class AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }
}
