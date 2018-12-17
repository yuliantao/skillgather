/**
 * 
 */
package com.ylt.springsecuritycore.properties;

/**
 * @author zhailiang
 *
 */
public class BrowserProperties {
	
	private SessionProperties session = new SessionProperties();

	private String loginPage = "login";

	private String logoutPage = "login";//默认退出直接跳转到登录页，用户可以自定义

	private String accessDeniedPage = "denied";
	
	private ResponseType loginType = ResponseType.REDIRECT;
	
	private int rememberMeSeconds = 3600*24*7;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public ResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(ResponseType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}

	public SessionProperties getSession() {
		return session;
	}

	public void setSession(SessionProperties session) {
		this.session = session;
	}

	public String getLogoutPage() {
		return logoutPage;
	}

	public void setLogoutPage(String logoutPage) {
		this.logoutPage = logoutPage;
	}

	public String getAccessDeniedPage() {
		return accessDeniedPage;
	}

	public void setAccessDeniedPage(String accessDeniedPage) {
		this.accessDeniedPage = accessDeniedPage;
	}
}
