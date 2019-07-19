package com.multidatasource.example.demo.config.datasource.annotation;

import java.lang.annotation.*;

/**
 * 指定数据源注解类
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
