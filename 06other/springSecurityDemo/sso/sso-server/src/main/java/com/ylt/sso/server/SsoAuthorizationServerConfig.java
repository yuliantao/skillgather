
        package com.ylt.sso.server;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
        import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
        import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
        import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
        import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
        import org.springframework.security.oauth2.provider.token.TokenEnhancer;
        import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
        import org.springframework.security.oauth2.provider.token.TokenStore;
        import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
        import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


/**
 * @author yuliantao
 * @create 2018-12-23 23:50
 * @description 功能描述
 */
@Configuration
@EnableAuthorizationServer
public class SsoAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("ylt1").secret("{bcrypt}"+new BCryptPasswordEncoder().encode("ylt1secret"))//指定应用的id和密码
                .accessTokenValiditySeconds(600)//令牌有效时间
                .refreshTokenValiditySeconds(2592000)//刷新令牌有效期
                .authorizedGrantTypes("authorization_code","refresh_token")//一共5中，这里设置3种就行
                .scopes("all","read","write","sy")//客户端根据需要传递scope参数，值是自定义的
                .redirectUris("http://xxyy.com")
                .and()//
                .withClient("ylt2").secret("{bcrypt}"+new BCryptPasswordEncoder().encode("ylt2secret"))
                .accessTokenValiditySeconds(600)
                .refreshTokenValiditySeconds(2592000)//刷新令牌有效期
                .authorizedGrantTypes("authorization_code","refresh_token")
                .scopes("all","read","write","sy")
                .redirectUris("http://xxyy.com");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
               /* .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
        if (jwtAccessTokenConverter!=null && jwtTokenEnhancer!=null)
        {
            //配置增强器链
            TokenEnhancerChain enhancerChain =new TokenEnhancerChain();
            List<TokenEnhancer> enhancers=new ArrayList<>();
            enhancers.add(jwtTokenEnhancer);
            enhancers.add(jwtAccessTokenConverter);
            enhancerChain.setTokenEnhancers(enhancers);

            endpoints
                    .tokenEnhancer(enhancerChain)
                    .accessTokenConverter(jwtAccessTokenConverter);
        }*/
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //security.tokenKeyAccess("permitAll()");
        security.tokenKeyAccess("isAuthenticated()");
        //此使用了springsecurity的授权表达式，表示在获取到tokenkey的时候需要认证
    }

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
        accessTokenConverter.setSigningKey("ylt");
        return accessTokenConverter;
    }
}