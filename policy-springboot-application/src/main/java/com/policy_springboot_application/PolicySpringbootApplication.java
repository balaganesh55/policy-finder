package com.policy_springboot_application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PolicySpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicySpringbootApplication.class, args);
	}
	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
