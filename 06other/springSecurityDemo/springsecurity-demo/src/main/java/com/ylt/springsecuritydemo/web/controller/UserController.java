package com.ylt.springsecuritydemo.web.controller;

import com.ylt.springsecuritybrowser.authentication.yltAuthenctiationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuliantao
 * @create 2018-12-02 11:20
 * @description 功能描述
 */
@Controller
public class UserController {

    @GetMapping("/hello")
    @ResponseBody
    public String gethello()
    {
        return "hello";
    }

    @RequestMapping("/s")
    public String login()
    {
        return "sss";

    }

}
