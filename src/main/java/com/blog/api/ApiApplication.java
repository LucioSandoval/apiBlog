package com.blog.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class ApiApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	/*@Configuration
	class ModelMapperConfiguration {
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}
	}*/
}
