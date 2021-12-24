package com.nicr0n.authorization.controller;

import com.nicr0n.swagger.entity.vo.Result;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @author: Nicr0n
 * @date: 2021/12/25  0:15
 * @email: Nicr0nFF@gmail.com
 */
@Api(tags = "认证中心")
@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
@Slf4j
public class AuthController {

	private TokenEndpoint tokenEndpoint;

	private KeyPair keyPair;

	@ApiOperation(value = "Oauth2认证", notes = "登录入口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "用户名"),
			@ApiImplicitParam(name = "password", value = "密码"),
			@ApiImplicitParam(name = "refresh_token", value = "刷新token"),
			@ApiImplicitParam(name = "grant_type", value = "授权模式", required = true),
			@ApiImplicitParam(name = "scope", value = "作用域", required = true),
			@ApiImplicitParam(name = "client_id", value = "Oauth客户端ID", required = true),
			@ApiImplicitParam(name = "client_secret", value = "Oauth客户端秘钥", required = true)
	})
	@PostMapping("/token")
	public Result<OAuth2AccessToken> postAccessToken(@ApiIgnore Principal principal,
													 @RequestParam  @ApiIgnore Map<String, String> parameters)
			throws HttpRequestMethodNotSupportedException {
		OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
		return Result.success(accessToken);
	}

	@GetMapping("/publicKey")
	public Map<String, Object> getPublicKey() {
		log.info("访问公钥接口");
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAKey key = new RSAKey.Builder(publicKey).build();
		return new JWKSet(key).toJSONObject();
	}
}
