package com.ylt.skillgather.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylt.skillgather.common.utils.ListToJsonTree;
import com.ylt.skillgather.system.entity.Ex.SystemMenuEx;
import com.ylt.skillgather.system.entity.PermissionUser;
import com.ylt.skillgather.system.service.IPermissionUserService;
import com.ylt.skillgather.system.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginControler {

    @Autowired
    IPermissionUserService iPermissionUserService;

    @Autowired
    ISystemMenuService iSystemMenuService;

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
                //获取菜单列表
                List<SystemMenuEx> list= ListToJsonTree.listCoreUrlMaping(iSystemMenuService.list(null));
                session.setAttribute("urllist",list);
                return "redirect:/main.html";
            }
            else {
                //登陆失败
                map.put("msg", "用户名密码错误");
                return "login";
            }
        }
        else
        {
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }

    @GetMapping(value = "/user/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.removeAttribute("loginUser");
        return "redirect:/login.html";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request,PermissionUser permissionUser )
    {
        System.out.println(request.getParameter("password"));
        return "1";
    }

}
