package com.nicr0n.authorization.test;

import com.nicr0n.authorization.service.feign.UserService;
import com.nicr0n.feign.entity.po.SysUser;
import com.nicr0n.swagger.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Nicr0n
 * @date: 2021/10/25    10:33
 * @email: Nicr0nFF@gmail.com
 */
@RestController
@RequestMapping("/system/auth")
@Slf4j
public class TestController {

    @Resource
    UserService userService;

    @GetMapping("/getUserByUsername")
    Result<SysUser> getUserByUserName(@RequestParam String username){
        return userService.getUserByUserName(username);
    }
}
