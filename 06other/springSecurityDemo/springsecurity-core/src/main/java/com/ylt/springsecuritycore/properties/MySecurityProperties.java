package com.ylt.springsecuritycore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuliantao
 * @create 2018-12-03 21:23
 * @description 功能描述
 */
@ConfigurationProperties(prefix = "ylt.security")
public class MySecurityProperties {

    private BrowserProperties browser=new BrowserProperties();

    private ValidateCodeProperties code =new ValidateCodeProperties();

    private List<String> excludeUrl = new ArrayList<>();

    private OAuth2Properties oauth2 =new OAuth2Properties();

    //private SocialProperties social = new SocialProperties();

    //region -- 基本的get，set 方法 --

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

 /*   public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }*/

    public List<String> getExcludeUrl() {
        return excludeUrl;
    }

    public void setExcludeUrl(List<String> excludeUrl) {
        this.excludeUrl = excludeUrl;
    }

    //endregion


    public OAuth2Properties getOauth2() {
        return oauth2;
    }

    public void setOauth2(OAuth2Properties oauth2) {
        this.oauth2 = oauth2;
    }
}
