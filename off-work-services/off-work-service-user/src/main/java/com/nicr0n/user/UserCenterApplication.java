package com.nicr0n.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: Nicr0n
 * @date: 2021/10/19 17:35
 * @email: Nicr0nFF@gmail.com
 */
// 启用服务发现
@EnableDiscoveryClient

// 启用mybatis mapper扫描
@MapperScan(basePackages = "com.nicr0n.*.mapper")

@SpringBootApplication
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class);
    }
}
