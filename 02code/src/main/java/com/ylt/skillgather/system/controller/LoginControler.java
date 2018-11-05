package com.ylt.skillgather.system.controller;

import com.ylt.skillgather.system.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginControler {

    @Autowired
    ILoginService iLoginService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session)
    {
        if(!StringUtils.isEmpty(username) && iLoginService.login(username,password)!=null){

            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return  "system/dashboard";
            //return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "system/login";
        }
    }

    @GetMapping("/test")
    @ResponseBody
    public String test()
    {
        return  "test";
    }
}
