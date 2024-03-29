package com.nicr0n.authorization.config;

import com.nicr0n.authorization.service.feign.UserCenterService;
import com.nicr0n.authorization.token.CustomTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeTokenGranter;
import org.springframework.security.oauth2.provider.code.RedisAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: Nicr0n
 * @date: 2021/10/21    15:33
 * @email: Nicr0nFF@gmail.com
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    @Qualifier("customUserDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    private UserCenterService userCenterService;

    /**
     * 用户验证信息的保存策略，可以保存在关系型数据库中，redis中，jwt中
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        // 保存在数据库中
//        return new JdbcTokenStore(dataSource);
        // 保存在redis中
//        return new RedisTokenStore(redisConnectionFactory);
        // 以jwt形式保存
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * 配置授权码模式授权码服务,不配置默认为内存模式
     *
     * @return
     */
    @Primary
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new RedisAuthorizationCodeServices(redisConnectionFactory);
    }


    /**
     * 用于校验注册的第三方客户端的信息，可以存储在数据库中，默认方式是存储在内存中
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置客户端信息，从数据库中读取，对应oauth_client_details表
        clients.jdbc(dataSource);
    }

    /**
     * 用于控制token的端点信息
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 配置token存储，一般配置redis存储
                .tokenStore(tokenStore())
                // 配置认证管理器
                .authenticationManager(authenticationManager)
                // 配置用户详情server，密码模式必须
                .userDetailsService(userDetailsService)
                // 配置授权码模式授权码服务,不配置默认为内存模式
                .authorizationCodeServices(authorizationCodeServices())
                // 配置grant_type模式，如果不配置则默认使用密码模式、简化模式、验证码模式以及刷新token模式，如果配置了只使用配置中，默认配置失效
                // 具体可以查询AuthorizationServerEndpointsConfigurer中的getDefaultTokenGranters方法
                .tokenGranter(tokenGranter(endpoints))
                .tokenEnhancer(tokenEnhancerChain())
                .accessTokenConverter(accessTokenConverter());
        // 配置TokenServices参数 可以考虑使用[DefaultTokenServices]，它使用随机值创建令牌
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        // 是否支持刷新Token
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setReuseRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        // 设置accessToken和refreshToken的默认超时时间(如果clientDetails的为null就取默认的，如果clientDetails的不为null取clientDetails中的)
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(1));
        tokenServices.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));
        endpoints.tokenServices(tokenServices);
    }

    /**
     * 允许表单验证
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.allowFormAuthenticationForClients();
        oauthServer
                // /oauth/token_key
                .tokenKeyAccess("isAuthenticated()")
                // /oauth/check_token
                .checkTokenAccess("permitAll()");
    }

    private TokenGranter tokenGranter(AuthorizationServerEndpointsConfigurer endpoints) {
        List<TokenGranter> tokenGranterList = new ArrayList<>();
        // 这里配置密码模式、刷新token模式、自定义手机号验证码模式、授权码模式、简化模式
        // 密码模式
        tokenGranterList.add(new ResourceOwnerPasswordTokenGranter(authenticationManager, endpoints.getTokenServices(), endpoints.getClientDetailsService(), endpoints.getOAuth2RequestFactory()));
        // 授权码模式
        tokenGranterList.add(new AuthorizationCodeTokenGranter(endpoints.getTokenServices(), endpoints.getAuthorizationCodeServices(), endpoints.getClientDetailsService(), endpoints.getOAuth2RequestFactory()));
        return new CompositeTokenGranter(tokenGranterList);
    }

    /**
     * jwt  token生成配置
     * @return
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 使用秘钥对对token进行签名
        converter.setKeyPair(keyPair());
        return converter;
    }

    /**
     * 自定义jwt增强链
     *
     * @return
     */
    @Bean
    public TokenEnhancerChain tokenEnhancerChain() {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(new CustomTokenEnhancer(userCenterService), accessTokenConverter()));
        return tokenEnhancerChain;
    }

    /**
     * 从classpath目录下的秘钥库获取秘钥对
     * @return 秘钥对
     */
    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource("key-pair.jks"), "123456".toCharArray());
        KeyPair keyPair = factory.getKeyPair("Nicr0n", "123456".toCharArray());
        return keyPair;
    }
}
