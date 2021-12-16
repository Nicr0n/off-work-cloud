package com.nicr0n.authorization.service.feign;

import com.nicr0n.feign.constants.FeignConstants;
import com.nicr0n.feign.entity.po.SysRole;
import com.nicr0n.feign.entity.po.SysUser;
import com.nicr0n.swagger.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2021/10/25    10:00
 * @email: Nicr0nFF@gmail.com
 */
@FeignClient(name = FeignConstants.USER_CENTER)
public interface UserCenterService {

    /**
     * feign rpc访问远程/getUserByUsername接口
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/system/user/byUsername")
    Result<SysUser> getUserByUserName(@RequestParam("username") String username);

    @GetMapping("/system/role/byUserID")
    Result<List<SysRole>> getRolesByUserID(@RequestParam("id") Long id);


}
