package com.ylt.skillgather.common.config;

import com.ylt.skillgather.common.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
此类配合springboot默认的配置联合使用（实现WebMvcConfigurer类，应用java8 功能）
还有一种配合springboot完成：在容器中添加相应的类，spring发现已经有该类就不继续默认配置
如果配置运行多个协调作用则会默认加上自己配置一起作用
 */
@Configuration
public class GlobalWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //此处可以不考虑静态资源，springboot已经配置好了，以前配置拦截器需要设置静态资源放行
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/user/login","/login.html","/index.html","/",
                        "/error/**","**/favicon.ico",
                        "/webjars/**","/asserts/**","/gentelella/**"
                        ,"/loginfile/**");
    }

    /*
    添加直接映射关系
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("aceplus/home");
        registry.addViewController("/home.html").setViewName("aceplus/home");
        registry.addViewController("/er4").setViewName("error/4xx");
        registry.addViewController("/er5").setViewName("error/5xx");

        //region -- 页面展示映射 --
        //ace风格
        registry.addViewController("/userinfo").setViewName("aceplus/userinfo");
        registry.addViewController("/action").setViewName("aceplus/PermissionAction");

        //gentelella风格
        registry.addViewController("/userinfo2").setViewName("gentelella/production/userinfo2");
        //endregion
    }


    /*
    实现国际化资源的解析器，替换默认
     */
/*    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }*/

    /*
    实现自定义的错误显示内容
     */
  /*  @Bean
    public MyErrorAttributes myErrorAttributes()
    {
        return new MyErrorAttributes();
    }*/
}
