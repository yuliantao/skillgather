package com.ylt.springsecuritybrowser;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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

    @Autowired
    private MyUserDetailsService userService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder  passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository()
    {
        JdbcTokenRepositoryImpl tokenRepository=new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter=new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(yltAuthenctiationFailureHandler);
        validateCodeFilter.setSecurityProperties(mySecurityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)//添加验证码过滤器
                .formLogin()
                    .loginPage("/authentication/require")//此处跳转到一个自定义的control方法上，便于判断登录的客户端类型而给出不同的输出（json还是html）
                    .loginProcessingUrl("/authentication/form")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successHandler(yltAuthenticationSuccessHandler)
                    .failureHandler(yltAuthenctiationFailureHandler)
                    .failureUrl("/authentication/require") //登录失败时的跳转链接，默认是/login?error
                    //.failureForwardUrl()//授权失败时的跳转链接
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(mySecurityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userService)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        "/error/**","**/favicon.ico",
                        mySecurityProperties.getBrowser().getLoginPage(),
                        "/webjars/**","/asserts/**"
                        ,"/loginfile/**","/code/image"
                ).permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

    }
}
