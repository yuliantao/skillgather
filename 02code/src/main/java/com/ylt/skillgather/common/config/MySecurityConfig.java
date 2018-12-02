package com.ylt.skillgather.common.config;

import com.ylt.skillgather.common.utils.OtherUtils;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yuliantao
 * @create 2018-12-02 23:52
 * @description 启用安全
 */
@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers((String[]) OtherUtils.getStaticSource().toArray()).permitAll()//放行
        .antMatchers()
    }
}
