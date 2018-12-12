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

	private String SignOutUrl =SecurityConstants.DEFAULT_LOGIN_PAGE_URL;// "/authentication/require";
	
	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
	
	private LoginResponseType loginType = LoginResponseType.REDIRECT;
	
	private int rememberMeSeconds = 3600*24*7;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginResponseType loginType) {
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

	public String getSignOutUrl() {
		return SignOutUrl;
	}

	public void setSignOutUrl(String signOutUrl) {
		SignOutUrl = signOutUrl;
	}
}
