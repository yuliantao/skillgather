package com.ylt.springsecuritybrowser;

import com.ylt.springsecuritycore.properties.ResponseType;
import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.properties.SecurityConstants;
import com.ylt.springsecuritycore.support.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuliantao
 * @create 2018-12-03 16:18
 * @description 功能描述
 */
@Controller
public class SecurityController{

    private Logger logger = LoggerFactory.getLogger(getClass());
    private RequestCache requestCache = new HttpSessionRequestCache();//此类存储跳转之前的链接

    @Autowired
    private MySecurityProperties mySecurityProperties;

    //region  --  配置未登录时返回json还是页面  ---

    /**
     * 需要身份认证时跳转到这里，可以判断是HTML跳转还是app方式
     */
    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest != null) {
                String targetUrl = savedRequest.getRedirectUrl();
                logger.info("跳转请求:" + targetUrl);
            }
        return jumpUtil(request, response,"访问的服务需要身份认证，请引导用户到登录页",
                mySecurityProperties.getBrowser().getLoginPage());
    }

    //判断是否为手机浏览器
    public boolean JudgeIsMoblie(HttpServletRequest request) {
        boolean isMoblie = false;
        String[] mobileAgents = {"iphone", "android", "ipad", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
                "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
                "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
                "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
                "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
                "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
                "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
                "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
                "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
                "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
                "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
                "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
                "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
                "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
                "Googlebot-Mobile"};
        if (request.getHeader("User-Agent") != null) {
            String agent = request.getHeader("User-Agent");
            for (String mobileAgent : mobileAgents) {
                if (agent.toLowerCase().indexOf(mobileAgent) >= 0 && agent.toLowerCase().indexOf("windows nt") <= 0 && agent.toLowerCase().indexOf("macintosh") <= 0) {
                    isMoblie = true;
                    break;
                }
            }
        }
        return isMoblie;
    }

    //endregion

    @RequestMapping(SecurityConstants.DEFAULT_SESSION_INVALID_URL)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public SimpleResponse sessionInvalid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String message="session失效";
        WebRequest webRequest=new ServletWebRequest(request,response);
        SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
        sessionStrategy.setAttribute(webRequest,"errorinfo",message);//传递传输到页面
        return jumpUtil(request, response,message,
                mySecurityProperties.getBrowser().getLoginPage());
    }

    @RequestMapping(SecurityConstants.DEFAULT_LOGOUT_PAGE_URL)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public SimpleResponse loginOut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        return jumpUtil(request, response,
                "退出成功，请引导用户到登录页",
                mySecurityProperties.getBrowser().getLogoutPage());
    }

    @RequestMapping(SecurityConstants.DEFAULT_DENIED_PAGE_URL)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public SimpleResponse accessdenied (HttpServletRequest request,HttpServletResponse response) throws IOException {
       return jumpUtil(request, response,
               "访问的服务没有权限，请引导用户到授权页",
               mySecurityProperties.getBrowser().getAccessDeniedPage());

    }

    /**
     * 非json交互返回视图
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(SecurityConstants.DEFAULT_JSONTOVIEW_PAGE_URL)
    public  String commonReturnUrl(HttpServletRequest request,HttpServletResponse response)
    {
        Object url = request.getAttribute("jumpurl");
        if (url!=null) {
            return url.toString();
        }
        else
        {
           return mySecurityProperties.getBrowser().getLoginPage();
        }
    }


    public SimpleResponse jumpUtil(HttpServletRequest request,HttpServletResponse response,String msg,String url) throws IOException {
        if (!ResponseType.JSON.equals(mySecurityProperties.getBrowser().getLoginType()))
        {
            request.setAttribute("jumpurl",url);
            try {
                request.getRequestDispatcher(SecurityConstants.DEFAULT_JSONTOVIEW_PAGE_URL).forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return  null;
        }
        else
        {
            return new SimpleResponse(msg);
        }
    }

    @RequestMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public String home(HttpServletRequest request,HttpServletResponse response)
    {
        return "home"; //用户名密码图片验证码模式
    }


}
