package com.nicr0n.authorization.service;

import com.nicr0n.authorization.service.feign.UserService;
import com.nicr0n.feign.entity.po.SysRole;
import com.nicr0n.feign.entity.po.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * @author: Nicr0n
 * @date: 2021/10/25    14:24
 * @email: Nicr0nFF@gmail.com
 */
@Slf4j
@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.getUserByUserName(username).getData();
        log.info("load user by username :{}", user.getUsername());

        User returnedUser = new User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("admin")));
        return returnedUser;
    }

    protected Set<SysRole> getRolesByID(Long id){
        return null;
    }
}
