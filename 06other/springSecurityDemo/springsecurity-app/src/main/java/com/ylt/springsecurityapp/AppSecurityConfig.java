/**
 * 
 */
package com.ylt.springsecurityapp;

import javax.sql.DataSource;

import com.ylt.springsecuritycore.authentication.AbstractChannelSecurityConfig;
import com.ylt.springsecuritycore.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.ylt.springsecuritycore.authorize.AuthorizeConfigManger;
import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.properties.SecurityConstants;
import com.ylt.springsecuritycore.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @author zhailiang
 *
 */
@Configuration
public class AppSecurityConfig extends AbstractChannelSecurityConfig {


	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;

	//短信登录认证
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

	//验证码（图片和手机短信2种方式）
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
/*	@Autowired
	YltAccessDeniedHandler yltAccessDeniedHandler;*/

	@Autowired
	private AuthorizeConfigManger authorizeConfigManger;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//配置认证信息
		//applyPasswordAuthenticationConfig(http);
		http.httpBasic();
		http.csrf().disable();
		//authorizeConfigManger.config(http.authorizeRequests());//此处配置了所有权限
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}
}
