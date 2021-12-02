package com.nicr0n.gateway.swagger;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Swagger资源聚合提供者 跨域配置
 *
 * @author: Nicr0n
 * @date: 2021/12/2    16:38
 * @email: Nicr0nFF@gmail.com
 */
@Component
@EnableConfigurationProperties(SwaggerAggregationProperties.class)
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {

    /**
     * 网关路由
     */
    private final RouteLocator routeLocator;

    @Resource
    private SwaggerAggregationProperties swaggerAggregationProperties;

    public SwaggerProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        Set<String> routes = new HashSet<>();
        // 取出Spring Cloud Gateway中的route
        routeLocator.getRoutes().subscribe(route -> {
            routes.add(route.getUri().getHost());
        });

        routes.forEach(route -> {
            // 拼接url
            String url = "/" + route.toLowerCase() + swaggerAggregationProperties.getApiDocsPath();
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setUrl(url);
            swaggerResource.setName(route);
            resources.add(swaggerResource);
        });

        return resources;
    }
}
