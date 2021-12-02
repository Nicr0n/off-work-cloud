package com.nicr0n.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.nicr0n.swagger.properties.SwaggerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: Nicr0n
 * @date: 2021/10/19 15:48
 * @email: Nicr0nFF@gmail.com
 * @discription: 自动配置swagger2 日后完善
 */
@Configuration
@EnableKnife4j
@EnableSwagger2WebFlux
// 如果在配置文件中配置了swagger.enable则启用自动配置，缺失开启
@ConditionalOnProperty(name = "swagger.enable",matchIfMissing = true)
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
    SwaggerProperties swaggerProperties(){
        return new SwaggerProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public Docket createRestApi(SwaggerProperties swaggerProperties){

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(),
                        swaggerProperties.getContact().getUrl(),
                        swaggerProperties.getContact().getEmail()))
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .build();

        // base-path处理
        // 当没有配置任何path的时候，解析/**
        if (swaggerProperties.getBasePath().isEmpty()) {
            swaggerProperties.getBasePath().add(BASE_PATH);
        }

        // exclude-path处理
        // 如果配置为空 则添加默认路径
        if (swaggerProperties.getExcludePath().isEmpty()) {
            swaggerProperties.getExcludePath().addAll(DEFAULT_EXCLUDE_PATH);
        }
        // 如果配置不为空则遍历配置文件添加到列表中
        List<Predicate<String>> excludePath = new ArrayList<>();
        swaggerProperties.getExcludePath().forEach(
                path->{
                    excludePath.add(PathSelectors.ant(path));
                }
        );

        ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerProperties.getHost())
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()));

        swaggerProperties.getBasePath().forEach(tempBasePath-> {
            apiSelectorBuilder.paths(PathSelectors.ant(tempBasePath));
        });

        swaggerProperties.getExcludePath().forEach(tempExcludePath->{
            apiSelectorBuilder.paths(PathSelectors.ant(tempExcludePath).negate());
        });

        return apiSelectorBuilder.build();
    }
}
