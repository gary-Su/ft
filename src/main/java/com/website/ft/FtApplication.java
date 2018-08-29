package com.website.ft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.website.ft.dao")
public class FtApplication {
	//(exclude = DataSourceAutoConfiguration.class)
	public static void main(String[] args) {
		SpringApplication.run(FtApplication.class, args);
	}
}
