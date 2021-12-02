package com.nicr0n.testprovider.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Nicr0n
 * @date: 2021/10/15 16:42
 * @email: Nicr0nFF@gmail.com
 */
@RestController
@Api(tags = "提供者测试")
public class TestController {

    @GetMapping("/hiProvider")
    public String hi(@RequestParam(value = "name", defaultValue = "Nicron", required = false) String name) {
        return "hi" + name;
    }

}
