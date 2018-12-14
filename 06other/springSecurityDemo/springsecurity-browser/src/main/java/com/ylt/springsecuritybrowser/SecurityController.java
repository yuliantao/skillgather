package com.ylt.springsecuritybrowser;

import com.ylt.springsecuritybrowser.support.SimpleResponse;
import com.ylt.springsecuritycore.properties.LoginResponseType;
import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.properties.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.jws.WebResult;
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
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private MySecurityProperties mySecurityProperties;

    /**
     * 需要身份认证时跳转到这里，可以判断是HTML跳转还是app方式
     */
    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        if (!LoginResponseType.JSON.equals(mySecurityProperties.getBrowser().getLoginType()))
        {
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest != null) {
                String targetUrl = savedRequest.getRedirectUrl();
                logger.info("引发跳转的请求是:" + targetUrl);
                //if (!JudgeIsMoblie(request))//判断是否是手机发出，以后可以升级判断是不是app发出
                redirectStrategy.sendRedirect(request, response, mySecurityProperties.getBrowser().getLoginPage());
            }
            return null;
        }
        else
        {
            return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
        }
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

    @RequestMapping("/authenticationlogin")
    public String login(HttpServletRequest request,HttpServletResponse response)
    {
        ServletWebRequest servletWebRequest=new ServletWebRequest(request,response);
        SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
        Object err=sessionStrategy.getAttribute(servletWebRequest,"errorinfo");
        if (err!=null)
        {
            //只是测试有没有值
        }
        //return "mobilelogin";//手机号短信验证码模式
        return "login"; //用户名密码图片验证码模式
    }

    @RequestMapping("/session/invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public String sessionInvalid(HttpServletRequest request,HttpServletResponse response)
    {
        String message="session失效";
        WebRequest webRequest=new ServletWebRequest(request,response);
        SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
        sessionStrategy.setAttribute(webRequest,"errorinfo",message);//传递传输到页面
         //return "mobilelogin";//手机号短信验证码模式
        return "login"; //用户名密码图片验证码模式
    }

    @RequestMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public String home(HttpServletRequest request,HttpServletResponse response)
    {
        return "home"; //用户名密码图片验证码模式
    }
}
