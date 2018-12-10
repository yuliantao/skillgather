/**
 * 
 */
package com.ylt.springsecuritybrowser.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ylt.springsecuritybrowser.support.SimpleResponse;
import com.ylt.springsecuritycore.properties.LoginResponseType;
import com.ylt.springsecuritycore.properties.MySecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhailiang
 *
 */
@Component("yltAuthenctiationFailureHandler")
public class yltAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MySecurityProperties mySecurityProperties;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		logger.info("登录失败");
		if (LoginResponseType.JSON.equals(mySecurityProperties.getBrowser().getLoginPage())) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(exception.getMessage())));
		}else{
			//跳转到登录页继续登录(带上错误信息)
			//super.onAuthenticationFailure(request, response, exception);
			request.getSession().setAttribute("errorinfo",exception.getMessage());
			redirectStrategy.sendRedirect(request, response, mySecurityProperties.getBrowser().getLoginPage());
		}
		
		
	}

}
