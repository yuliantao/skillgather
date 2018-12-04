package com.ylt.springsecuritybrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringsecurityBrowserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityBrowserApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello()
    {
        return  "hello spring security";
    }
}
