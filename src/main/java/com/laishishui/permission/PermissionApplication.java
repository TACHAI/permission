package com.laishishui.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PermissionApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PermissionApplication.class, args);
    }

    //打成war包使用
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        // 此处Application.class 替换为springboot默认启动类
        return builder.sources(PermissionApplication.class);
    }



}
