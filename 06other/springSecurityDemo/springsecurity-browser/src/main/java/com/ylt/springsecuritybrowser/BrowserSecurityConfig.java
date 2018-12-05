package com.ylt.springsecuritybrowser;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author yuliantao
 * @create 2018-12-03 13:11
 * @description 功能描述
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MySecurityProperties mySecurityProperties;

    @Autowired
    private AuthenticationSuccessHandler yltAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler yltAuthenctiationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(yltAuthenticationSuccessHandler)
                .failureHandler(yltAuthenctiationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require","/",
                        "/error/**","**/favicon.ico", mySecurityProperties.getBrowser().getLoginPage(),
                        "/webjars/**","/asserts/**","/gentelella/**"
                        ,"/loginfile/**"
                ).permitAll()
                .anyRequest()
                .authenticated();
    }

    @Autowired
    private MyUserDetailsService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

    }
}
