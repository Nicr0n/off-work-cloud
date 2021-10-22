package com.nicr0n.user.controller;


import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.po.SysUser;
import com.nicr0n.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@RestController
@RequestMapping("/system/user")
@Api(tags = "用户中心")
@Slf4j
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @ApiOperation(value = "获取用户",notes = "根据用户名获取用户信息")
    @GetMapping("/getUserByUsername")
    public Result<SysUser> getUserByUserName(@RequestParam String username){
        log.debug("get user by username:{}",username);
        return Result.judgeObject(sysUserService.getUserByUsername(username));
    }
}

