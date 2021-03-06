package com.ylt.springsecuritycore.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 收集所有的AuthorizeConfigProvider然后执行，这样可以实现分模块分应用配置权限
 */
@Component
public class YltAuthorizeConfigManger implements AuthorizeConfigManger {

    @Autowired
   private List<AuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        for (AuthorizeConfigProvider provider:authorizeConfigProviders) {
            provider.config(config);
        }
        config.anyRequest().authenticated();//除了上面的配置剩下的都需要认证访问
        //因为要自定义权限所以先注释掉
    }
}
