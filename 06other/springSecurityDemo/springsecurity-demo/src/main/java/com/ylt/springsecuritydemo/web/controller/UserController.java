package com.ylt.springsecuritydemo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
