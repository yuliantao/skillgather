package com.ylt.springsecurityonly.properties;

/**
 * @author yuliantao
 * @create 2018-12-03 21:23
 * @description 功能描述
 */
public class BrowserProperties {

    private String loginPage="/login";
    private LoginResponseType loginResponseType=LoginResponseType.REDIRECT;

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
}
