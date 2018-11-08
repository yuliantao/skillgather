package com.ylt.skillgather.system.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.ylt.skillgather.system.entity.PermissionAction;
import com.ylt.skillgather.system.entity.PermissionUser;
import com.ylt.skillgather.system.mapper.PermissionActionMapper;
import com.ylt.skillgather.system.service.IPermissionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginControler {

    @Autowired
    IPermissionUserService iPermissionUserService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username)) {
            Map<String, String> rvMap = new HashMap<String, String>();
            rvMap.put("username", username);
            rvMap.put("password", password);
            PermissionUser permissionUser = iPermissionUserService.getOne(new QueryWrapper<PermissionUser>().allEq(rvMap));
            if (permissionUser != null) {

                //登陆成功，防止表单重复提交，可以重定向到主页
                session.setAttribute("loginUser", username);
                return "system/dashboard";
                //return "redirect:/main.html";
            }
            else {
                //登陆失败
                map.put("msg", "用户名密码错误");
                return "system/login";
            }
        }
        else
        {
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "system/login";
        }

    }



    @GetMapping("/test")
    @ResponseBody
    public String test()
    {
        return  "test";
    }
}
