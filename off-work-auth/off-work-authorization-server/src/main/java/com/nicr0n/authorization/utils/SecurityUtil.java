package com.nicr0n.authorization.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @author: Nicr0n
 * @date: 2021/10/25    14:58
 * @email: Nicr0nFF@gmail.com
 */
public class SecurityUtil {

    public static User getCurrentUser(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null){
            System.out.println("当前登录状态过期");
        }
        return (User) authentication.getPrincipal();
    }
}
