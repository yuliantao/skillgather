package com.ylt.springsecuritybrowser.authorize;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.properties.SecurityConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuliantao
 * @create 2018-12-17 22:50
 * @description 功能描述
 */
@Component
public class YltAccessDeniedHandler implements AccessDeniedHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private MySecurityProperties mySecurityProperties;

    public YltAccessDeniedHandler(MySecurityProperties mySecurityProperties)
    {
        this.mySecurityProperties=mySecurityProperties;
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        logger.info("无权限访问");
        String logOutUrl=mySecurityProperties.getBrowser().getAccessDeniedPage();
        if (StringUtils.isBlank(logOutUrl))
        {
            //如果没有配置跳转链接就返回自定义的json对象，让前端根据内容进行判断出来
        }else
        {
            new DefaultRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, SecurityConstants.DEFAULT_DENIED_PAGE_URL);
        }
    }
}
