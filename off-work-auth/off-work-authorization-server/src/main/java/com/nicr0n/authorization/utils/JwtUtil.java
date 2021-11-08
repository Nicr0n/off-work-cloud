package com.nicr0n.authorization.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: Nicr0n
 * @date: 2021/11/8    11:35
 * @email: Nicr0nFF@gmail.com
 */
public class JwtUtil {
    @Value("${spring.security.oauth2.jwt.signingKey}")
    private String signingKey;

    public Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
