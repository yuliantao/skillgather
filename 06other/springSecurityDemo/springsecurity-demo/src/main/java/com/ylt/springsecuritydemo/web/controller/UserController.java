package com.ylt.springsecuritydemo.web.controller;


import com.ylt.springsecuritycore.properties.MySecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * @author yuliantao
 * @create 2018-12-02 11:20
 * @description 功能描述
 */
@Controller
public class UserController {

    Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private MySecurityProperties securityProperties;

    @GetMapping("/hello")
    @ResponseBody
    public String gethello()
    {
        return "hello";
    }

    @RequestMapping("/s")
    public String login(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        logger.info(String.valueOf(session.getClass()));
        return "sss";

    }

    @GetMapping("/me")
    @ResponseBody
    public Object getCurrentUser(Authentication user,HttpServletRequest request) throws UnsupportedEncodingException {
        String header=request.getHeader("Authorization");//从请求头拿到token
        String token= StringUtils.substringAfter(header,"bearer ");//去掉前面的类型
        //此处注意是UTF-8，在jwt使用秘钥时用的是utf-8编码进行面签，此处有jjwt需要制定编码进行验签
        Claims claims = Jwts.parser().setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
        .parseClaimsJws(token).getBody();
        String company=(String)claims.get("company");//获取之前面签是自定义对象的值
        logger.info(company);
        return user;
    }

}
