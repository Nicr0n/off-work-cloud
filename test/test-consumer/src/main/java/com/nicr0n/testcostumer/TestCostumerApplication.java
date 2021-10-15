package com.nicr0n.testcostumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//启用服务发现
@EnableDiscoveryClient
//启用openFeign服务调用
@EnableFeignClients

@SpringBootApplication
public class TestCostumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCostumerApplication.class, args);
    }

}
