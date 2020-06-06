package com.mju.zjj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: ItemManageSystem
 * @description:
 * @author: Mr.ZhengJunJie
 * @create: 2020-06-03 14:55
 **/
@SpringBootApplication
public class ItemManageSystem {
    @Configuration
    @EnableWebMvc
    public class WebMvcConfg implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            WebMvcConfigurer.super.addCorsMappings(registry);
            registry.addMapping("/**")//需要跨域访问的Map路径
                    .allowedOrigins("http://localhost:8000")//允许跨域访问的ip及端口
                    .allowedHeaders("*")//允许跨域访问的Headers内容
                    .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")//允许跨域访问的方法，OPTIONS必须设置Shiro中用到
                    .allowCredentials(true);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ItemManageSystem.class,args);
    }
}
