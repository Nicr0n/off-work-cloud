package com.nicr0n.authorization.controller;

import com.github.xiaoymin.knife4j.annotations.Ignore;
import com.nicr0n.authorization.entity.po.SysUserDTO;
import com.nicr0n.authorization.service.feign.UserCenterService;
import com.nicr0n.authorization.utils.IPUtils;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.Map;

/**
 * @author: Nicr0n
 * @date: 2021/12/25  0:15
 * @email: Nicr0nFF@gmail.com
 */
@Tag(name = "认证中心")
@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
@Slf4j
public class AuthController {

	private TokenEndpoint tokenEndpoint;

	private KeyPair keyPair;

	private UserCenterService userCenterService;

	@Operation(description = "Oauth2认证")
	@Parameters({
			@Parameter(name = "username", description = "用户名"),
			@Parameter(name = "password", description = "密码"),
			@Parameter(name = "refresh_token", description = "刷新token"),
			@Parameter(name = "grant_type", description = "授权模式", required = true),
			@Parameter(name = "scope", description = "作用域", required = true),
			@Parameter(name = "client_id", description = "Oauth客户端ID", required = true),
			@Parameter(name = "client_secret", description = "Oauth客户端秘钥", required = true)
	})
	@PostMapping("/token")
	public OAuth2AccessToken postAccessToken(@Ignore Principal principal,
											 @RequestParam @Ignore Map<String, String> parameters, HttpServletRequest request)
			throws HttpRequestMethodNotSupportedException {
		OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
		// 登录成功更新上次登录IP和时间
		String ip = IPUtils.getClientIP(request);
		SysUserDTO sysUserDTO = new SysUserDTO();
		sysUserDTO.setLastLoginIp(ip);
		sysUserDTO.setLastLoginTime(new Date());
		userCenterService.updateUserByID(Long.parseLong((String) accessToken.getAdditionalInformation().get("user_id")), sysUserDTO);
		return accessToken;
	}

	@GetMapping("/publicKey")
	public Map<String, Object> getPublicKey() {
		log.info("访问公钥接口");
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAKey key = new RSAKey.Builder(publicKey).build();
		return new JWKSet(key).toJSONObject();
	}
}
