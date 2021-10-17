package com.nicr0n.oauth2.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: Nicr0n
 * @date: 2021/10/17  21:37
 * @email: Nicr0nFF@gmail.com
 */
public class BCryptPasswordEncoderUtils {

	private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	/**
	 * 将原密码加密得到加密后的密文
	 * @param rawPasswd	未加密的密码
	 * @return	加密后得到的密文
	 */
	public static String encodeRawPasswd(String rawPasswd){
		return bCryptPasswordEncoder.encode(rawPasswd);
	}

	/**
	 * 比较原密码与密文是否一致
	 * @param rawPasswd
	 * @param hashedPasswd
	 * @return
	 */
	public static boolean matches(String rawPasswd,String hashedPasswd){
		return bCryptPasswordEncoder.matches(rawPasswd,hashedPasswd);
	}
}
