package cn.ylt.sso.client;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yuliantao
 * @create 2018-12-27 0:41
 * @description 功能描述
 */
@EnableOAuth2Sso
@Configuration
@EnableWebSecurity
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/"
                        ,"/client2/login**","/login**","/callback/"
                        , "/webjars/**"
                        , "/error**"
                )
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
