package com.multidatasource.example.demo;

import com.multidatasource.example.demo.config.datasource.dynamic.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//注册动态多数据源
@Import(DynamicDataSourceRegister.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
