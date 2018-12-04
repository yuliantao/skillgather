package com.ylt.springsecurityonly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuliantao
 * @create 2018-12-03 23:11
 * @description 功能描述
 */
@Controller
public class SecurityControllerForHtml {

    /**
     * 专用于网页访问跳转
     * @return
     */
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
}
