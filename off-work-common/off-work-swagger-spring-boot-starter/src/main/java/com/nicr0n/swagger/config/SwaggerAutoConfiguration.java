package com.nicr0n.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.nicr0n.swagger.properties.SwaggerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2021/10/19 15:48
 * @email: Nicr0nFF@gmail.com
 * @discription: 自动配置swagger2 日后完善
 */
@Configuration
@EnableKnife4j
// 如果在配置文件中配置了swagger.enable则启用自动配置，缺失开启
@ConditionalOnProperty(name = "swagger.enable", matchIfMissing = true)
@Slf4j
public class SwaggerAutoConfiguration {

	/**
	 * 默认的排除路径，排除Spring Boot默认的错误处理路径和端点
	 */
	private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

	private static final String BASE_PATH = "/**";

	@Bean
	@ConditionalOnMissingBean
		// 注入配置类
	SwaggerProperties swaggerProperties() {
		return new SwaggerProperties();
	}
}
