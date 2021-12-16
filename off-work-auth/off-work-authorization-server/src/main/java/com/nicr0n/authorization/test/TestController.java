package com.nicr0n.authorization.test;

import com.nicr0n.authorization.service.feign.UserCenterService;
import com.nicr0n.authorization.utils.SecurityUtil;
import com.nicr0n.feign.entity.po.SysRole;
import com.nicr0n.feign.entity.po.SysUser;
import com.nicr0n.swagger.entity.vo.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2021/10/25    10:33
 * @email: Nicr0nFF@gmail.com
 */
@RestController
@RequestMapping("/system/auth")
@Slf4j
public class TestController {

    @Autowired
    UserCenterService userCenterService;

    @GetMapping("/getUserByUsername")
    Result<SysUser> getUserByUserName(@RequestParam String username) {
        return userCenterService.getUserByUserName(username);
    }

    @GetMapping("/getRoleByUserIDs")
    Result<List<SysRole>> getRolesByUserID(@RequestParam Long id) {
        return userCenterService.getRolesByUserID(id);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/currentUserInfo")
    public Result<Authentication> getCurrentUser() {
        log.debug("get current login user");
        return Result.judgeObject(SecurityUtil.getCurrentUser());
    }
}
