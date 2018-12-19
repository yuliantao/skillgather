package com.ylt.springsecurityapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer//添加这个相当于已经把springsecurityOAauth的四种默认的授权模式方式引入实现了认证服务器
public class yltAuthorizationServerConfig {
}
