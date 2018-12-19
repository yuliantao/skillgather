package com.ylt.springsecuritycore;


import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.support.MyUserDetailsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yuliantao
 * @create 2018-12-03 21:27
 * @description 功能描述
 */
@Configuration
@EnableConfigurationProperties(MySecurityProperties.class)
public class SecurityCoreConfig {
    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public UserDetailsService getUserDetailsService()
    {
        return new MyUserDetailsService();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
}
