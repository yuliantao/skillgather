package com.ylt.springsecuritydemo.config;

import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
/*        configurer.registerCallableInterceptors();//配置对应拦截器
        configurer.registerDeferredResultInterceptors();//配置对应拦截器
        configurer.setDefaultTimeout();//配置过期时间
        configurer.setTaskExecutor();//配置特别的线程池*/
    }

}
