package com.example.todoapp;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("Todo Application API")
						.version("1.0.0")
						.description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
						.termsOfService("http://swagger.io/terms/")
						.license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
