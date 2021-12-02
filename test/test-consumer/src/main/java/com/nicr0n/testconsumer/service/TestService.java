package com.nicr0n.testconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Nicr0n
 * @date: 2021/10/15 17:07
 * @email: Nicr0nFF@gmail.com
 */
@FeignClient("test-provider")
public interface TestService {

    @GetMapping("/hiProvider")
    String hi(@RequestParam(value = "name", defaultValue = "forezp", required = false) String name);
}
