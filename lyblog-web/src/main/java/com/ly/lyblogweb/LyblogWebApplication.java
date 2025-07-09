package com.ly.lyblogweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ly"})
@MapperScan("com.ly.lyblogcommon.domain.mapper")
public class LyblogWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyblogWebApplication.class, args);
    }

}
