package com.ylt.springsecuritybrowser;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityBrowserApplicationTests {

    @Autowired
    WebApplicationContext webApplicationContext;


    @Test
    public void contextLoads() {
        MySecurityProperties detailsService= webApplicationContext.getBean(MySecurityProperties.class);
        System.out.println(detailsService);
    }

}
