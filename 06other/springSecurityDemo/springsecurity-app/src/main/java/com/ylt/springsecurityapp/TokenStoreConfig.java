package com.ylt.springsecurityapp;

import com.ylt.springsecurityapp.jwt.YltJwtTokenEnhancer;
import com.ylt.springsecuritycore.properties.MySecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author yuliantao
 * @create 2018-12-22 0:15
 * @description 功能描述
 */
@Configuration
public class TokenStoreConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    //这样token被存到redis中
    @Bean
    @ConditionalOnProperty(prefix = "ylt.security.oauth2",name = "storeType",havingValue = "redis")
    public TokenStore redisTokenStore()
    {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Configuration
    @ConditionalOnProperty(prefix = "ylt.security.oauth2",name = "storeType",havingValue = "jwt",matchIfMissing = true)
    public static class JwtTokenConfig{


        @Autowired
        private MySecurityProperties securityProperties;

        /**
         * 负责存储
         * @return
         */
        @Bean
        public TokenStore jwtTokenStore()
        {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        /**
         * 要进行逻辑处理和定制自己的实现
         * @return
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
            accessTokenConverter.setSigningKey(securityProperties.getOauth2().getJwtSigningKey());
            return accessTokenConverter;
        }

        /**
         * 添加jwt的增强器
         * @return
         */
        @Bean
        @ConditionalOnMissingBean(name = "jwtTokenEnhancer")
        public TokenEnhancer jwtTokenEnhancer()
        {
            return new YltJwtTokenEnhancer();
        }

    }
}
