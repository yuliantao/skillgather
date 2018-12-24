/**
 * 
 */
package com.ylt.sso.server;


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
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhailiang
 *
 */
@EnableWebSecurity
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Autowired
	private UserDetailsService userDetailsService;
*/

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


	@Override
	public void configure(HttpSecurity http) throws Exception {

		//此处设置的security只是作为spring默认的几种方式配置，自定义的
		//安全配置在资源服务器中
		http.httpBasic();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userDetailsService);//.passwordEncoder(passwordEncoder());
		auth.inMemoryAuthentication()
				.withUser("user")
				.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"))
				.roles("user")
		;

	}
}
