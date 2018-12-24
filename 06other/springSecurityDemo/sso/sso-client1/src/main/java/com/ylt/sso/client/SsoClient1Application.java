package com.ylt.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso //使该配置
public class SsoClient1Application {

    @GetMapping("/user")
    public Authentication user(Authentication user)
    {
        return user;
    }

/*    @GetMapping("/login")
    public String login()
    {
        return  "sss";
    }

    @GetMapping("/index")
    public String index()
    {
        return  "index.html";
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SsoClient1Application.class,args);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("ylt");
        return accessTokenConverter;
    }
}
