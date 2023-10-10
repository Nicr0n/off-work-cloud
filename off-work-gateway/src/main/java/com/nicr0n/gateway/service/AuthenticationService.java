package com.nicr0n.gateway.service;

import cn.hutool.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Nicr0n
 * @date: 2021/11/9    9:22
 * @email: Nicr0nFF@gmail.com
 */
@Component
@Slf4j
public class AuthenticationService {

    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String singingKey;

    public Boolean checkToken(String token){
        return JWTUtil.verify(token,singingKey.getBytes());
    }
}
