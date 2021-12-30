package com.nicr0n.db.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.nicr0n.db.handler.MyMetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: Nicr0n
 * @date: 2021/12/30    18:33
 * @email: Nicr0nFF@gmail.com
 */
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {

    /**
     * 自动填充数据库创建人、创建时间、更新人、更新时间
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
        return globalConfig;
    }
}
