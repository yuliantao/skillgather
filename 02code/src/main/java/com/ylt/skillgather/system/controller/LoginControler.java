package com.ylt.skillgather.system.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.ylt.skillgather.system.entity.PermissionUser;
import com.ylt.skillgather.system.mapper.PermissionActionMapper;
import com.ylt.skillgather.system.service.IPermissionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginControler {

    @Autowired
    PermissionActionMapper iPermissionUserService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session)
    {

        iPermissionUserService.selectOne()

        if(!StringUtils.isEmpty(username)){
//            Wrapper<PermissionUser> obj=
//            iPermissionUserService  !=null
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
