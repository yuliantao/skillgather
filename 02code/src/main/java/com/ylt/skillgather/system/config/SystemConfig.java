package com.ylt.skillgather.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(value = "com.ylt.skillgather.system.dao")
@Configuration
public class SystemConfig {

}
