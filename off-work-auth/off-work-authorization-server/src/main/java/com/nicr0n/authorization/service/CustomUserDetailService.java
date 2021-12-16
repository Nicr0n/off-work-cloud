package com.nicr0n.authorization.service;

import com.nicr0n.authorization.service.feign.UserCenterService;
import com.nicr0n.feign.entity.po.SysRole;
import com.nicr0n.feign.entity.po.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Nicr0n
 * @date: 2021/10/25    14:24
 * @email: Nicr0nFF@gmail.com
 */
@Slf4j
@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserCenterService userCenterService;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userCenterService.getUserByUserName(username).getData();
        log.info("load user by username :{}", user.getUsername());
        return new User(user.getUsername(), user.getPassword(), getRolesByUser(user));
    }

    /**
     * 获取登录者角色权限集合
     * @param user
     * @return
     */
    protected Set<GrantedAuthority> getRolesByUser(SysUser user) {
        List<SysRole> roleList = userCenterService.getRolesByUserID(user.getUserId()).getData();
        log.info("user:{},roles:{}", user.getUsername(), roleList);

        return roleList.stream().map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toSet());
    }
}
