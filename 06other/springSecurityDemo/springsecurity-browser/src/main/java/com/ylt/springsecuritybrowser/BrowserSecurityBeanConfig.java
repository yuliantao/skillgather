/**
 * 
 */
package com.ylt.springsecuritybrowser;

import com.ylt.springsecuritybrowser.authorize.YltAccessDeniedHandler;
import com.ylt.springsecuritybrowser.logout.yltLogoutSuccessHandler;
import com.ylt.springsecuritybrowser.session.ImoocExpiredSessionStrategy;
import com.ylt.springsecuritybrowser.session.ImoocInvalidSessionStrategy;
import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.support.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;



/**
 * @author zhailiang
 *
 */
@Configuration
public class BrowserSecurityBeanConfig {

	@Autowired
	private MySecurityProperties securityProperties;
	
	@Bean
	@ConditionalOnMissingBean(InvalidSessionStrategy.class)
	public InvalidSessionStrategy invalidSessionStrategy(){
		return new ImoocInvalidSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
	}
	
	@Bean
	@ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
	public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
		return new ImoocExpiredSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
	}
	@Bean
	@ConditionalOnMissingBean(LogoutSuccessHandler.class)
	public yltLogoutSuccessHandler yltLogoutSuccessHandler()
	{
		return  new yltLogoutSuccessHandler(securityProperties);
	}
	@Bean
	@ConditionalOnMissingBean(AccessDeniedHandler.class)
	public YltAccessDeniedHandler yltAccessDeniedHandler()
	{
		return  new YltAccessDeniedHandler(securityProperties);
	}

}
