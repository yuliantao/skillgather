package com.ylt.security.rbac;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yuliantao
 * @create 2018-12-17 21:40
 * @description 功能描述
 */
@Component("rbacService")
public class RbacServiceImpl implements RbacService {

    private AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
       Object principal=authentication.getPrincipal();
       //此处先返回true,正常应该是false判断
       boolean hasPermission=true;
       if (principal instanceof UserDetails)
       {
           String username=((UserDetails)principal).getUsername();
           //根据用户名去获取所有权限的url
           Set<String> urls=new HashSet<>();//此处应该去读取数据库用户对应的权限信息
           for (String url:urls)
           {
               if ((antPathMatcher.match(url,request.getRequestURI()))&&(request.getMethod().equalsIgnoreCase("post")))
               {
                   hasPermission=true;
                   break;
               }
           }
       }
        return hasPermission;
    }
}
