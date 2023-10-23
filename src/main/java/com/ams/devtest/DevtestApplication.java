package com.ams.devtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DevtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevtestApplication.class, args);
	}

}
