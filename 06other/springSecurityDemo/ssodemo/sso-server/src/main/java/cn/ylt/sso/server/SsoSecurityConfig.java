package cn.ylt.sso.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yuliantao
 * @create 2018-12-25 21:43
 * @description 功能描述
 */
@EnableWebSecurity
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
//        http.formLogin()
//                .loginPage("/authentication/require")
//                .loginProcessingUrl("/authentication/form")
//                .and().authorizeRequests()
//                .antMatchers("/authentication/require",
//                        "/authentication/form",
//                        "/**/*.js",
//                        "/**/*.css",
//                        "/**/*.jpg",
//                        "/**/*.png",
//                        "/**/*.woff2"
//                )
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
