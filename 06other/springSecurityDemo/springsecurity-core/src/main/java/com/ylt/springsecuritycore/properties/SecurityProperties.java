package com.ylt.springsecuritycore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuliantao
 * @create 2018-12-03 21:23
 * @description 功能描述
 */
@ConfigurationProperties(prefix = "ylt.security")
@Configuration
public class SecurityProperties {
    private BrowserProperties browser=new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
