package com.ylt.springsecuritycore.properties;

/**
 * @author yuliantao
 * @create 2018-12-03 21:23
 * @description 功能描述
 */
public class BrowserProperties {

    private String loginPage="/authenticationlogin";
    private LoginResponseType loginResponseType=LoginResponseType.REDIRECT;
    private int rememberMeSeconds=3600*24*7;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginResponseType getLoginResponseType() {
        return loginResponseType;
    }

    public void setLoginResponseType(LoginResponseType loginResponseType) {
        this.loginResponseType = loginResponseType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
