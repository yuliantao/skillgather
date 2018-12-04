package com.ylt.springsecuritycore;


import com.ylt.springsecuritycore.properties.MySecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuliantao
 * @create 2018-12-03 21:27
 * @description 功能描述
 */
@Configuration
@EnableConfigurationProperties(MySecurityProperties.class)
public class SecurityCoreConfig {
}
