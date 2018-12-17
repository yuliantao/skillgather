package com.ylt.springsecuritycore.authorize;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

@Component
@Order(Integer.MIN_VALUE)
public class YltAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
     private MySecurityProperties securityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        List<String> excludeUrl = securityProperties.getExcludeUrl();
        excludeUrl.add(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL);
        excludeUrl.add(SecurityConstants.DEFAULT_SESSION_INVALID_URL);
        excludeUrl.add(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*");
        excludeUrl.add(SecurityConstants.DEFAULT_LOGOUT_PAGE_URL);
        excludeUrl.add(SecurityConstants.DEFAULT_DENIED_PAGE_URL);
        excludeUrl.add(SecurityConstants.DEFAULT_JSONTOVIEW_PAGE_URL);
        excludeUrl.add("/error/**");
        excludeUrl.add("**/favicon.ico");
        excludeUrl.add("/webjars/**");
        excludeUrl.add("/signOut");
        excludeUrl.add("/loginfile/**");
        String[] arry=excludeUrl.toArray(new String[excludeUrl.size()]);
        config.antMatchers(arry).permitAll();
    }
}
