package com.nicr0n.authorization.token;

import com.google.common.collect.Maps;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Map;

/**
 * @author: Nicr0n
 * @date: 2021/11/5    14:59
 * @email: Nicr0nFF@gmail.com
 */
public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String,Object> additionalInfo = Maps.newHashMap();
        // 自定义token内容
        additionalInfo.put("depart", oAuth2Authentication.getName());
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
