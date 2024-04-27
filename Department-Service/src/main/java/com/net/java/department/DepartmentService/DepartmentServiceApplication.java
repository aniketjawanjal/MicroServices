package com.net.java.department.DepartmentService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
		System.out.println("Department Service Started");
	}

//	@Bean
//	public WebClient webClient() {
//		return WebClient.builder().build();
//	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
