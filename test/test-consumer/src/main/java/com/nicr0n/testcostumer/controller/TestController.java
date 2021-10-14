package com.nicr0n.testcostumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Nicr0n
 * @date: 2021.10.2021/10/15  1:50
 * @email: Nicr0nFF@gmail.com
 */
@RestController

// 支持动态更新配置
@RefreshScope
public class TestController {

    @Value("${nacos.config}")
    private String config;

    @GetMapping("/helloConfig")
    public String helloConfig(){
        return config;
    }
}
