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

@EnableWebSecurity
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {


/*
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


	@Override
	public void configure(HttpSecurity http) throws Exception {
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

	}*/
@Autowired
private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/authentication/require")
				.loginProcessingUrl("/authentication/form")
				.and().authorizeRequests()
				.antMatchers("/authentication/require",
						"/authentication/form",
						"/**/*.js",
						"/**/*.css",
						"/**/*.jpg",
						"/**/*.png",
						"/**/*.woff2"
				)
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.csrf().disable();
//        http.formLogin().and().authorizeRequests().anyRequest().authenticated();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
