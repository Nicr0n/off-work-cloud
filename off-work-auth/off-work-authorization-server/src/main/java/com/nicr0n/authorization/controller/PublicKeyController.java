package com.nicr0n.authorization.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @author: Nicr0n
 * @date: 2021/12/8    14:40
 * @email: Nicr0nFF@gmail.com
 */
@Api(tags = "认证中心")
@RestController
@AllArgsConstructor
@RequestMapping("/oauth")
@Slf4j
public class PublicKeyController {

    private KeyPair keyPair;

    @GetMapping("/publicKey")
    public Map<String,Object> getPublicKey(){
        log.info("访问公钥接口");
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}
