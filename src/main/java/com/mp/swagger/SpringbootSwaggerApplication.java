package com.mp.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwaggerApplication.class, args);
		System.err.println("SpringBoot Swagger2.0 ............http://localhost:8080/swagger-ui.html");
	}

}
