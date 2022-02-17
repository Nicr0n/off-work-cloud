package com.nicr0n.user.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.nicr0n.common.constants.SecurityConstants;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author: Nicr0n
 * @date: 2022/2/17  8:45
 * @email: Nicr0nFF@gmail.com
 */
public class SecurityUtils {
	public static Long getUserID(){
		Long userid = null;
		String token =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(SecurityConstants.TOKEN_KEY);
		// 去掉bearer开头
		token = token.substring(7);
		JWT jwt = JWTUtil.parseToken(token);
		if (jwt!=null){
			userid = Long.parseLong((String) jwt.getPayload().getClaim("user_id"));
		}
		return userid;
	}
}
