package com.ylt.springsecuritydemo.web.controller;

import com.ylt.springsecuritybrowser.authentication.yltAuthenctiationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

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

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

}
