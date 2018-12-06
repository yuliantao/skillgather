package com.ylt.springsecuritycore.properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author yuliantao
 * @create 2018-12-03 21:23
 * @description 功能描述
 */
@ConfigurationProperties(prefix = "ylt.security")
@Configuration
@Qualifier("test")
public class MySecurityProperties {
    private BrowserProperties browser=new BrowserProperties();

    private ValidateCodeProperties code =new ValidateCodeProperties();

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
}