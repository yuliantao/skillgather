package com.ylt.springsecurityapp;

import com.ylt.springsecurityapp.authentication.yltAuthenctiationFailureHandler;
import com.ylt.springsecuritycore.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.ylt.springsecuritycore.authorize.AuthorizeConfigManger;
import com.ylt.springsecuritycore.properties.SecurityConstants;
import com.ylt.springsecuritycore.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author yuliantao
 * @create 2018-12-20 1:04
 * @description 功能描述
 */
@Configuration
@EnableResourceServer
public class yltResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler yltAuthenticationSuccessHandler;
    @Autowired
    protected yltAuthenctiationFailureHandler yltAuthenticationFailureHandler;
    @Autowired
    private DataSource dataSource;
    //验证码验证（图片和手机短信2种方式）
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;
    //短信登录认证
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private AuthorizeConfigManger authorizeConfigManger;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(yltAuthenticationSuccessHandler)
                .failureHandler(yltAuthenticationFailureHandler);
        http.apply(validateCodeSecurityConfig);//开启验证码验证功能
        http.apply(smsCodeAuthenticationSecurityConfig)
            .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_SESSION_INVALID_URL
                        ,SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*"
                        ,SecurityConstants.DEFAULT_LOGOUT_PAGE_URL
                        ,SecurityConstants.DEFAULT_DENIED_PAGE_URL
                        ,SecurityConstants.DEFAULT_JSONTOVIEW_PAGE_URL
                        ,"/error/**"
                        ,"**/favicon.ico"
                        ,"/webjars/**"
                        ,"/signOut"
                        ,"/loginfile/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .csrf().disable();
        authorizeConfigManger.config(http.authorizeRequests());//此处配置了所有权限
    }
}
