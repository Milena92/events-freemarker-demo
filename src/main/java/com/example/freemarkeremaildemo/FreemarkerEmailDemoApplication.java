package com.example.freemarkeremaildemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FreemarkerEmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreemarkerEmailDemoApplication.class, args);
	}

}
