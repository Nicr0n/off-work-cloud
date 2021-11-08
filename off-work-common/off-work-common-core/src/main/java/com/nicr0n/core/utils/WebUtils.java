package com.nicr0n.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Nicr0n
 * @date: 2021/11/8    12:06
 * @email: Nicr0nFF@gmail.com
 */
public class WebUtils {


    public static HttpServletRequest getHttpServletRequest(){
        try {
            return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getServerUrl(HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + request.getContextPath();
        return url;
    }
}
