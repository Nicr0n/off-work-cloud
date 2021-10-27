package com.nicron.test;

import com.nicr0n.oauth2.common.utils.BCryptPasswordEncoderUtils;

/**
 * @author: Nicr0n
 * @date: 2021/10/17  22:04
 * @email: Nicr0nFF@gmail.com
 */
public class BCPEUtilsTest {
	public static void main(String[] args) {
		System.out.println(BCryptPasswordEncoderUtils.encodeRawPasswd("Nicron1998"));
		System.out.println(BCryptPasswordEncoderUtils.matches("admin","$2a$10$6fVQs6s0zSO13hoLm9ziMOB9CfiCYRt/rzQVKrE.41.XNHXXKNt/G"));
	}
}
