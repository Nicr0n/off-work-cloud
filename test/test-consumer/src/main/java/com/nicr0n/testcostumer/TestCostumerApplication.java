package com.nicr0n.testcostumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//配置服务发现
@EnableDiscoveryClient

@SpringBootApplication
public class TestCostumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCostumerApplication.class, args);
    }

}
