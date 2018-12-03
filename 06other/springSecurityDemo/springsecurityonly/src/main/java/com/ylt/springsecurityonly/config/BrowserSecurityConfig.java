package com.ylt.springsecurityonly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yuliantao
 * @create 2018-12-03 13:11
 * @description 功能描述
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/loginpage")
                .loginProcessingUrl("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/loginpage", "/user/login","/login.html","/index.html","/",
                        "/error/**","**/favicon.ico",
                        "/webjars/**","/asserts/**","/gentelella/**"
                        ,"/loginfile/**").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Autowired
    private MyUserDetailsService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

    }
}
