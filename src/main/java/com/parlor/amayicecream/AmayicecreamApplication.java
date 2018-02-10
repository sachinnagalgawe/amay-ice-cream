package com.parlor.amayicecream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = { "com.parlor.amayicecream" })
public class AmayicecreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmayicecreamApplication.class, args);
	}
}