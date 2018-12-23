/**
 * 
 */
package com.ylt.springsecurityapp.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.properties.ResponseType;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;


/**
 * @author zhailiang
 *
 */
@Component("yltAuthenticationSuccessHandler")
public class yltAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MySecurityProperties mySecurityProperties;
	@Autowired
	private ClientDetailsService clientDetailsService;
	@Autowired
	private AuthorizationServerTokenServices authorizationServerTokenServices;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info("登录成功");
		//开始进行token的获取
		String header = request.getHeader("Authorization");//获取请求头的第三方系统信息
		if (header == null || !header.toLowerCase().startsWith("basic ")) {
			throw new UnapprovedClientAuthenticationException("请求头中无client信息");
		}
		String[] tokens = this.extractAndDecodeHeader(header, request);
		assert tokens.length == 2;
		//获取第三方的id和密码
		String clientId = tokens[0];
		String clientSecret=tokens[1];

		ClientDetails clientDetails=clientDetailsService.loadClientByClientId(clientId);
		if (clientDetails==null)
		{
			throw  new  UnapprovedClientAuthenticationException("clientid对应的配置信息不存在："+clientId);
		}
		else if (!passwordEncoder.matches(clientSecret,StringUtils.substringAfter(clientDetails.getClientSecret(),"{bcrypt}"))){
			throw new  UnapprovedClientAuthenticationException("clientSecret不匹配："+clientId);
		}
		//第一个参数是一个map,根据不同的授权模式提供的参数是不一样的，由于该参数的作用是去验证用户的，但本设计中是先登录成功也就是已经
		//拿到了用户登录信息authentication，所以也就不需要了。第三个参数不用验证因为都是内部系统需要什么权限都放
		//最后一个参数表示使用什么模式，spring提供了默认的4中授权模式，我目前使用自定义所有用custom
		TokenRequest tokenRequest=new TokenRequest(MapUtils.EMPTY_MAP,clientId,clientDetails.getScope(),"custom");
		OAuth2Request oAuth2Request =tokenRequest.createOAuth2Request(clientDetails);//创建
		OAuth2Authentication oAuth2Authentication=new OAuth2Authentication(oAuth2Request,authentication);
		OAuth2AccessToken token =authorizationServerTokenServices.createAccessToken(oAuth2Authentication);

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(objectMapper.writeValueAsString(token));
	}
	private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {
		byte[] base64Token = header.substring(6).getBytes("UTF-8");
		byte[] decoded;
		try {
			decoded = Base64.getDecoder().decode(base64Token);
		} catch (IllegalArgumentException var7) {
			throw new BadCredentialsException("Failed to decode basic authentication token");
		}
		String token = new String(decoded, "UTF-8");
		int delim = token.indexOf(":");
		if (delim == -1) {
			throw new BadCredentialsException("Invalid basic authentication token");
		} else {
			return new String[]{token.substring(0, delim), token.substring(delim + 1)};
		}
	}
}
