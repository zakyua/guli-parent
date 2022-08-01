package com.atguigu.educenter.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ChenCheng
 * @create 2022-07-12 21:09
 */
@Configuration
@MapperScan("com.atguigu.educenter.mapper")
public class EduConfig {

    /**
     * 逻辑删除插件
     */
    @Bean
    public ISqlInjector getISqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
