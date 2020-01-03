package com.yzw.apitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;


//@MapperScan("com.huilu.testplatform.mapper") //扫描的mapper
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableScheduling
@Configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class MyTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyTestApplication.class, args);
    }
}
