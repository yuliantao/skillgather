package com.ylt.springsecurityapp;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.properties.OAuth2ClientProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAuthorizationServer//添加这个相当于已经把springsecurityOAauth的四种默认的授权模式方式引入实现了认证服务器
public class yltAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    Logger logger=LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private MySecurityProperties securityProperties;

    @Autowired
    private TokenStore tokenStore;

    @Autowired(required = false)
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired(required = false)
    private TokenEnhancer jwtTokenEnhancer;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
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
        }
    }

    //配置第三方应用，配置了这个yml中配置的client-id和client-secret就没用了
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
  /*      InMemoryClientDetailsServiceBuilder builder=clients.inMemory();
        if (ArrayUtils.isNotEmpty(securityProperties.getOauth2().getClients()))
        {
            for(OAuth2ClientProperties config:securityProperties.getOauth2().getClients())
            {
                builder.withClient(config.getClientId()).secret(config.getClientSecret())
                        .accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
                        .authorizedGrantTypes(config.getAuthorizedGrantTypes())
                        .scopes(config.getScopes());
            }
        }*/

        clients.inMemory()
        .withClient("ylt").secret("{bcrypt}"+new BCryptPasswordEncoder().encode("yltsecret"))//指定应用的id和密码
           .accessTokenValiditySeconds(600)//令牌有效时间
           .refreshTokenValiditySeconds(2592000)//刷新令牌有效期
           .authorizedGrantTypes("authorization_code","password","refresh_token")//一共5中，这里设置3种就行
           .scopes("all","read","write","sy")//客户端根据需要传递scope参数，值是自定义的
           .redirectUris("http://xxyy.com")
        .and()
        .withClient("dingdan").secret("{bcrypt}"+new BCryptPasswordEncoder().encode("dingdans"))
          .accessTokenValiditySeconds(600)
          .refreshTokenValiditySeconds(2592000)//刷新令牌有效期
          .authorizedGrantTypes("authorization_code","password","refresh_token")
          .scopes("all","read","write","sy")
          .redirectUris("http://xxyy.com");
    }

}
