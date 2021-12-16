package com.nicr0n.user.controller;


import com.nicr0n.swagger.entity.vo.Result;
import com.nicr0n.user.entity.po.SysRole;
import com.nicr0n.user.service.SysRoleService;
import com.nicr0n.user.service.SysUserRoleService;
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
    SysRoleService sysRoleService;

    @Autowired
    SysUserRoleService sysUserRoleService;

    @ApiOperation(value = "按照用户ID获取角色列表")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    @GetMapping("/byUserID")
    public Result<List<SysRole>> getRolesByUserID(@RequestParam Long id) {
        log.debug("get roles list by userID:{}", id);
        return Result.judgeObject(sysUserRoleService.getRolesByUserID(id));
    }
}

