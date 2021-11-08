package com.nicr0n.authorization.controller;

import cn.hutool.json.JSONObject;
import com.nicr0n.core.utils.WebUtils;
import com.nicr0n.swagger.entity.vo.Result;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Nicr0n
 * @date: 2021/11/8    10:59
 * @email: Nicr0nFF@gmail.com
 */
@RestController
public class AuthorizationController {

    @PostMapping("/login")
    public Result OauthLogin() {
        return null;
    }

    @GetMapping("/check_token")
    public Result checkToken(@RequestParam String token) {
        RestTemplate restTemplate = new RestTemplate();
        String url = WebUtils.getServerUrl(WebUtils.getHttpServletRequest()) + "/oauth/check_token";

        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("token", token);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(postParameters);
        try {
            JSONObject result = restTemplate.postForObject(url, request, JSONObject.class);
            return Result.success(result);
        } catch (HttpClientErrorException e) {
            return Result.fail(e.getResponseBodyAsString());
        }
    }
}
