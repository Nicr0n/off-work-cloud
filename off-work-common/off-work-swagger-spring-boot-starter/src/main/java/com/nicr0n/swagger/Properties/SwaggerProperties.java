package com.nicr0n.swagger.Properties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Nicr0n
 * @date: 2021/10/19 15:52
 * @email: Nicr0nFF@gmail.com
 */
@Data
@ConfigurationProperties("spring.swagger")
public class SwaggerProperties {

    private static final String DEFAULT_VALUE = "";

    /**
     * 是否开启swagger
     */
    private Boolean enabled;
    /**
     * 标题
     */
    private String title = DEFAULT_VALUE;
    /**
     * 描述
     */
    private String description = DEFAULT_VALUE;
    /**
     * 版本
     */
    private String version = DEFAULT_VALUE;
    /**
     * 许可证
     */
    private String license = DEFAULT_VALUE;
    /**
     * 许可证URL
     */
    private String licenseUrl = DEFAULT_VALUE;
    /**
     * 服务条款URL
     */
    private String termsOfServiceUrl = DEFAULT_VALUE;

    /**
     * swagger会解析的包路径
     */
    private String basePackage = DEFAULT_VALUE;

    /**
     * host信息
     */
    private String host = DEFAULT_VALUE;

    /**
     * 联系人信息
     */
    private Contact contact = new Contact();

    /**
     * swagger会解析的url规则
     */
    private List<String> basePath = new ArrayList<>();
    /**
     * 在basePath基础上需要排除的url规则
     */
    private List<String> excludePath = new ArrayList<>();

    /**
     * 分组文档
     */
    private Map<String, GroupInfo> groups = new LinkedHashMap<>();

    /**
     * 全局参数配置
     */
    private List<GlobalOperationParameter> globalOperationParameters;
    @Data
    @NoArgsConstructor
    public static class GroupInfo {

        /**
         * 标题
         */
        private String title = DEFAULT_VALUE;
        /**
         * 描述
         */
        private String description = DEFAULT_VALUE;

        /**
         * 版本
         */
        private String version = DEFAULT_VALUE;

        /**
         * 许可证
         */
        private String license = DEFAULT_VALUE;

        /**
         * 许可证URL
         */
        private String licenseUrl = DEFAULT_VALUE;

        /**
         * 服务条款URL
         */
        private String termsOfServiceUrl = DEFAULT_VALUE;

        private Contact contact = new Contact();

        /**
         * swagger会解析的包路径
         */
        private String basePackage = DEFAULT_VALUE;

        /**
         * swagger会解析的url规则
         */
        private List<String> basePath = new ArrayList<>();
        /**
         * 在basePath基础上需要排除的url规则
         */
        private List<String> excludePath = new ArrayList<>();

        /**
         * 分组里的全局参数
         */
        private List<GlobalOperationParameter> globalOperationParameters;

    }

    @Data
    public static class GlobalOperationParameter{
        /**
         * 参数名*
         */
        private String name;

        /**
         * 描述信息
         */
        private String description;

        /**
         * 指定参数类型
         */
        private String modelRef;

        /**
         * 参数放在哪个地方:header,query,path,body.form
         */
        private String parameterType;

        /**
         * 参数是否必须传
         */
        private String required;
    }

    @Data
    @NoArgsConstructor
    public static class Contact {
        /**
         * 联系人
         */
        private String name = DEFAULT_VALUE;
        /**
         * 联系人url
         */
        private String url = DEFAULT_VALUE;
        /**
         * 联系人email
         */
        private String email = DEFAULT_VALUE;

    }

}
