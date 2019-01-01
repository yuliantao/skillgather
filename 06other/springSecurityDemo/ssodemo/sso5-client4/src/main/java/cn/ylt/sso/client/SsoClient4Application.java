package cn.ylt.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuliantao
 * @create 2018-12-28 1:11
 * @description 功能描述
 */
@SpringBootApplication
//@EnableOAuth2Sso
@RestController
public class SsoClient4Application {
    public static void main(String[] args) {
        SpringApplication.run(SsoClient4Application.class,args);
    }

    @GetMapping("/user")
    public Authentication user(Authentication user)
    {
        return user;
    }
}
