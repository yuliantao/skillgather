/**
 * 
 */
package com.ylt.springsecuritybrowser;

import javax.sql.DataSource;

import com.ylt.springsecuritybrowser.authorize.YltAccessDeniedHandler;
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
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;


/**
 * @author zhailiang
 *
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

	@Autowired
	private MySecurityProperties securityProperties;
	
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
	private SpringSocialConfigurer imoocSocialSecurityConfig;
	*/

	//注入session处理逻辑
	@Autowired
	private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
	
	@Autowired
	private InvalidSessionStrategy invalidSessionStrategy;

	@Autowired
	LogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	YltAccessDeniedHandler yltAccessDeniedHandler;

	@Autowired
	private AuthorizeConfigManger authorizeConfigManger;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//配置认证信息
		applyPasswordAuthenticationConfig(http);
		http
				//关闭验证码
				/*.apply(validateCodeSecurityConfig)
				.and()*/
				//关闭短信登录功能
				/*.apply(smsCodeAuthenticationSecurityConfig)*/
				/*.and()
				.apply(imoocSocialSecurityConfig)*/
				//关闭记住我功能
				/*.and()
				.rememberMe()
					.tokenRepository(persistentTokenRepository())
					.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
					.userDetailsService(userDetailsService)
					.and()*/
			.sessionManagement()
				.invalidSessionStrategy(invalidSessionStrategy)//过期策略
				.maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())//最大session数
				//.maxSessionsPreventsLogin(true)
				.maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())//是否阻止新登录
				.expiredSessionStrategy(sessionInformationExpiredStrategy)//并发策略
				.and()
				.and()
			.logout()
				.logoutUrl("/signOut")//默认是/logout，当security发现是这个链接自动退出
				.logoutSuccessHandler(logoutSuccessHandler)
				//.logoutSuccessUrl(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
				.deleteCookies("JSESSIONID")
				.and()
			.csrf().disable()
			//配置权限拒绝处理类
			.exceptionHandling()
				.accessDeniedHandler(yltAccessDeniedHandler);

			authorizeConfigManger.config(http.authorizeRequests());//此处配置了所有权限
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);//.passwordEncoder(new BCryptPasswordEncoder());因为数据库中密码已经定位了那种加密解密方式
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//此处主要是用于remenberme功能
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}
}
