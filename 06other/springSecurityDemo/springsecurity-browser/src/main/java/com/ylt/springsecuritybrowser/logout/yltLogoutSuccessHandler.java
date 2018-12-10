package com.ylt.springsecuritybrowser.logout;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class yltLogoutSuccessHandler implements LogoutSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private MySecurityProperties mySecurityProperties;

    public yltLogoutSuccessHandler(MySecurityProperties mySecurityProperties)
    {
        this.mySecurityProperties=mySecurityProperties;
    }
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("退出成功");
        String signOutUrl=mySecurityProperties.getBrowser().getSignOutUrl();
        if (StringUtils.isBlank(signOutUrl))
        {
            //如果没有配置跳转链接就返回自定义的json对象，让前端根据内容进行判断出来
        }else {
            httpServletResponse.sendRedirect(signOutUrl);
        }
    }
}















