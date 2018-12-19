package com.ylt.springsecuritydemo.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yuliantao
 * @create 2018-12-02 11:20
 * @description 功能描述
 */
@Controller
public class UserController {

    Logger logger= LoggerFactory.getLogger(getClass());

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

}
