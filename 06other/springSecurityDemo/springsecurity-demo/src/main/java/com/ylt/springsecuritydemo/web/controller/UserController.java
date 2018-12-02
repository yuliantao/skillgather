package com.ylt.springsecuritydemo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuliantao
 * @create 2018-12-02 11:20
 * @description 功能描述
 */
@RestController
public class UserController {

    @GetMapping("/user/{id:\\d}")//此处可以使用正则表达式
    public String getUsername(@PathVariable("id") String id)
    {
        return  "";
    }
}
