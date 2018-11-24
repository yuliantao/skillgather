package com.ylt.skillgather.coreframe.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylt.skillgather.common.utils.ListToJsonTree;
import com.ylt.skillgather.coreframe.entity.CoreframeUser;
import com.ylt.skillgather.coreframe.entity.Ex.CoreframeMenuEx;
import com.ylt.skillgather.coreframe.service.ICoreframeMenuService;
import com.ylt.skillgather.coreframe.service.ICoreframeUserService;
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
    ICoreframeUserService  iCoreframeUserService;

    @Autowired
    ICoreframeMenuService iCoreframeMenuService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username)) {
            Map<String, String> rvMap = new HashMap<String, String>();
            rvMap.put("username", username);
            rvMap.put("password", password);
            CoreframeUser  coreframeUser = iCoreframeUserService.getOne(new QueryWrapper<CoreframeUser>().allEq(rvMap));
            if (coreframeUser != null) {
                //登陆成功，防止表单重复提交，可以重定向到主页
                session.setAttribute("loginUser", username);
                //获取菜单列表
                List<CoreframeMenuEx> list= ListToJsonTree.listCoreUrlMaping(iCoreframeMenuService.list(null));
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
    public String test(HttpServletRequest request,CoreframeUser permissionUser )
    {
        System.out.println(request.getParameter("password"));
        return "1";
    }

}
