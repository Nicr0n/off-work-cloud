package com.nicr0n.user.controller;


import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.po.SysRole;
import com.nicr0n.user.service.SysRoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@RestController
@RequestMapping("/system/role")
@Api(tags = "角色管理")
@Slf4j
public class SysRoleController {

    @Autowired
    SysRoleService roleService;

}

