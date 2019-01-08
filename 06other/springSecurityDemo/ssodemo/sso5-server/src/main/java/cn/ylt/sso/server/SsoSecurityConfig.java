package cn.ylt.sso.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Configuration
@EnableWebSecurity
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService ssoUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        //http.httpBasic().and().csrf().disable();
        http.formLogin().and().csrf().disable();
//        http.formLogin().and().authorizeRequests()
//                .antMatchers(
//                        "/oauth/**","/login/**"
//                       ,"/client2/login/**","/login**"
//                        ,"http://127.0.0.1:8082/client2/index.html",
//                        "/client2/index.html",
//                        "/index.html"
//                ).permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      /*  auth.inMemoryAuthentication()
                .withUser("qq")
                .password(new BCryptPasswordEncoder().encode("123")).authorities("ROLE_ADMIN")
                .and()
                .withUser("xx")
                .password(new  BCryptPasswordEncoder().encode("123")).authorities("ROLE_ADMIN")
                .and().passwordEncoder( passwordEncoder());*/


        auth.userDetailsService(ssoUserDetailsService).passwordEncoder(passwordEncoder());
//        auth.parentAuthenticationManager(authenticationManagerBean())
//                .inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())
//                .withUser("tt")
//                .password(passwordEncoder()
//                        .encode("123"))
//                .roles("USER");

     }

}
