package com.ylt.skillgather.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yuliantao
 * @create 2018-12-02 23:57
 * @description 系统公用的方法
 */
public class OtherUtils {

    /**
     * 获取系统放行的静态资源和普通用户都可访问资源
     * 目前写在本项目，后续应该存储在数据库中
     * @return
     */
    public static List<String> getStaticSource()
    {
        List<String> list=new ArrayList<>();
        String[] arry=new  String[]{
        "/user/login","/login.html","/index.html","/",
                "/error/**","**/favicon.ico",
                "/webjars/**","/asserts/**","/gentelella/**"
                ,"/loginfile/**"};
        list.addAll(Arrays.asList(arry));
        return list;
    }
}
