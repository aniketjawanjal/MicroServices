package net.java.orgnizationservice.orgnizationservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class OrgnizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgnizationServiceApplication.class, args);
		System.out.println("Organization Start...");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
