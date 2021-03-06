package cn.ylt.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuliantao
 * @create 2018-12-25 21:31
 * @description 功能描述
 */
@SpringBootApplication
@RestController
public class SsoClient2Application {
    public static void main(String[] args) {
        SpringApplication.run(SsoClient2Application.class,args);
    }

    @GetMapping("/user")
    public Authentication user(Authentication user)
    {
        return user;
    }

    @RequestMapping("/test")
    public String test(Authentication user)
    {
        int d=3;
        d=d+9;
        System.out.println(d);
        return "tes";
    }
}
