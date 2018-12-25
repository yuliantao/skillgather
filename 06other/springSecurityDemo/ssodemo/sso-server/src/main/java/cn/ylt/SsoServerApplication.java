package cn.ylt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 * @author yuliantao
 * @create 2018-12-25 20:58
 * @description 功能描述
 */
@SpringBootApplication
@Controller
public class SsoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoServerApplication.class,args);
    }
}