    package com.ylt.sso.server;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.NoOpPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
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
        /*clients.inMemory()
                .withClient("ylt1")
                .secret("{bcrypt}"+new BCryptPasswordEncoder().encode("ylt1secret"))//指定应用的id和密码
                .authorizedGrantTypes("authorization_code","refresh_token")//一共5中，这里设置3种就行
                .scopes("all","read","write","sy")//客户端根据需要传递scope参数，值是自定义的
                .redirectUris("http://localhost:8080/client1/login")
                .and()//
                .withClient("ylt2")
                .secret("{bcrypt}"+new BCryptPasswordEncoder().encode("ylt2secret"))
                .authorizedGrantTypes("authorization_code","refresh_token")
                .scopes("all","read","write","sy")
                .redirectUris("http://localhost:8060/client2/login");*/
        clients.inMemory()
                .withClient("ylt1")
                .secret("{bcrypt}"+new BCryptPasswordEncoder().encode("ylt1s"))//("ylt1s")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("all","read","write")
                .autoApprove(true)
                .and()
                .withClient("ylt2")
                .secret("{bcrypt}"+new BCryptPasswordEncoder().encode("ylt2s"))//("ylt2s")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("all","read","write")
                .autoApprove(true);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //security.passwordEncoder(new  BCryptPasswordEncoder()); // 密码加密策略
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