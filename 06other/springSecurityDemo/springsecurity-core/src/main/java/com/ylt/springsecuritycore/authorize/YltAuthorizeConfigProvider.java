package com.ylt.springsecuritycore.authorize;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class YltAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
     private MySecurityProperties securityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(
        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                securityProperties.getBrowser().getLoginPage(),
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
					/*securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".json",
					securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".html",*/
                "/user/regist","/signOut",
                "/error/**","**/favicon.ico",
                "/webjars/**","/asserts/**","/session/invalid"
                ,"/loginfile/**").permitAll();

    }
}
