package com.nicr0n.user.controller;


import com.nicr0n.swagger.entity.vo.PageParam;
import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.po.SysRole;
import com.nicr0n.user.entity.po.SysUser;
import com.nicr0n.user.entity.vo.SysUserListPage;
import com.nicr0n.user.service.SysUserRoleService;
import com.nicr0n.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@RestController
@RequestMapping("/system/user")
@Api(tags = "用户管理")
@Slf4j
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/current")
    public Result<SysUser> getCurrentUser(){
        return Result.judgeObject(sysUserService.getCurrentUser());
    }

    @ApiOperation(value = "按照用户名获取用户")
    @ApiImplicitParam(name = "username", value = "用户名", required = true)
    @GetMapping("/byUsername")
    public Result<SysUser> getUserByUserName(@RequestParam String username) {
        log.debug("get user by username:{}", username);
        return Result.judgeObject(sysUserService.getUserByUsername(username));
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public Result<SysUserListPage> getUserList(PageParam pageParam){
        log.debug("get users page:{} perPage:{}",pageParam.getPage(),pageParam.getPerPage());
        return Result.judgeObject(sysUserService.getUserList(pageParam));
    }

}

