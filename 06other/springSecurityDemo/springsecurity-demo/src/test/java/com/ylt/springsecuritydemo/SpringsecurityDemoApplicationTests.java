package com.ylt.springsecuritydemo;

import com.ylt.springsecuritybrowser.MyUserDetailsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityDemoApplicationTests {

    @Autowired
    WebApplicationContext webApplicationContext;

    //快速模拟HTTP请求，不用每次启动服务器
    MockMvc  mockMvc;

    @Before
    public  void setup()
    {
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void contextLoads() {
        MyUserDetailsService detailsService=(MyUserDetailsService) webApplicationContext.getBean(MyUserDetailsService.class);
        System.out.println(detailsService);
    }

}
