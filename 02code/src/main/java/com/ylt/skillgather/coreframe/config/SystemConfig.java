package com.ylt.skillgather.coreframe.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(value = "com.ylt.skillgather.*.mapper")
@Configuration
public class SystemConfig {

}
