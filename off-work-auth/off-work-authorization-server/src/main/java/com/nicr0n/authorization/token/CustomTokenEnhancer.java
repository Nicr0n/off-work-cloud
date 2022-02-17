package com.nicr0n.authorization.token;

import com.google.common.collect.Maps;
import com.nicr0n.authorization.service.feign.UserCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
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
@RequiredArgsConstructor
public class CustomTokenEnhancer implements TokenEnhancer {

	UserCenterService userCenterService;

	public CustomTokenEnhancer(UserCenterService userCenterService) {
		this.userCenterService = userCenterService;
	}

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
		Map<String, Object> additionalInfo = Maps.newHashMap();
		// 自定义token内容
//        additionalInfo.put("depart", oAuth2Authentication.getName());
		additionalInfo.put("user_id", userCenterService.getUserByUserName(((User) oAuth2Authentication.getPrincipal()).getUsername()).getData().getUserId().toString());
		((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
		return oAuth2AccessToken;
	}
}
