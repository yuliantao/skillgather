package cn.ylt.sso.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author yuliantao
 * @create 2018-12-25 21:00
 * @description 功能描述
 */
@Configuration
@EnableAuthorizationServer
public class SsoAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("ylt1")
                .secret("{bcrypt}"+new BCryptPasswordEncoder().encode("ylt1"))
                .authorizedGrantTypes("authorization_code","refresh_token")
                .scopes("all")
                .redirectUris("http://127.0.0.1:8081/client1/index.html")
                .autoApprove(true)
                .and()
                .withClient("ylt2")
                .secret("{bcrypt}"+new BCryptPasswordEncoder().encode("ylt2"))
                .authorizedGrantTypes("authorization_code","refresh_token")
                .scopes("all")
                .redirectUris("http://127.0.0.1:8082/client2/index.html")
                .autoApprove(true)
                ;
    }

    @Bean
    public TokenStore jwtTokenStore()
    {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("ylt");
        return accessTokenConverter;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");
    }
}
