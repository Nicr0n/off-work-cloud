package com.nicr0n.testconsumer.controller;

import com.nicr0n.testconsumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Nicr0n
 * @date: 2021/10/15  1:50
 * @email: Nicr0nFF@gmail.com
 */
@RestController

// 支持动态更新配置
@RefreshScope
public class TestController {

    @Autowired
    TestService testService;

    @Value("${nacos.config}")
    private String config;

    @GetMapping("/helloConfig")
    public String helloConfig() {
        return config;
    }

    @GetMapping("/hi")
    public String hiFeign() {
        return testService.hi("feign");
    }
}
