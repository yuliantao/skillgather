package com.ylt.springsecurityonly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuliantao
 * @create 2018-12-03 13:18
 * @description 功能描述
 */
@RestController
public class UserInfo {

    @GetMapping("/hello")
    @ResponseBody
    public String gethello()
    {
        return "hello";
    }

}
