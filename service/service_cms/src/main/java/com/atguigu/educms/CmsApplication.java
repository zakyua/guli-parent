package com.atgui.educms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ChenCheng
 * @create 2022-07-12 10:40
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.atguigu"})
@MapperScan("com.atguigu.educms.mapper")
public class CmsApplication {

    public static void main(String[] args) {
       SpringApplication.run(CmsApplication.class, args);
    }

}
