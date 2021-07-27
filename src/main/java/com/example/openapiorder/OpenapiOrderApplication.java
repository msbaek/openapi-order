package com.example.openapiorder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OpenapiOrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(OpenapiOrderApplication.class, args);
		log.debug("http://localhost:8080/swagger-ui.html");
	}
}
