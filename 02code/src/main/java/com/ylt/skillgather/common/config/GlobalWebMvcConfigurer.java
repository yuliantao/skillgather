package com.ylt.skillgather.common.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylt.skillgather.common.component.LoginHandlerInterceptor;

import com.ylt.skillgather.common.utils.OtherUtils;
import com.ylt.skillgather.coreframe.entity.CoreframeUrltoview;
import com.ylt.skillgather.coreframe.service.ICoreframeUrltoviewService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/*
此类配合springboot默认的配置联合使用（实现WebMvcConfigurer类，应用java8 功能）
还有一种配合springboot完成：在容器中添加相应的类，spring发现已经有该类就不继续默认配置
如果配置运行多个协调作用则会默认加上自己配置一起作用
 */
@Configuration
public class GlobalWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private ICoreframeUrltoviewService iCoreframeUrltoviewService;

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                //放行的资源
                excludePathPatterns(OtherUtils.getStaticSource());
    }

    /*
    添加直接映射关系
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //region -- 页面展示映射 --
        //ace风格，动态获取url匹配到映射
        List<CoreframeUrltoview> list = iCoreframeUrltoviewService.list(null);
        for (CoreframeUrltoview systemUrltoview:list) {
            registry.addViewController(systemUrltoview.getShowUrl()).setViewName(systemUrltoview.getMapingUrl());
        }
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
