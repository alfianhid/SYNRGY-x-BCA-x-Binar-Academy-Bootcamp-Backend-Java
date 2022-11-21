package com.binarxbca.chapter5;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class Chapter5Application {
	public static void main(String[] args) {
		SpringApplication.run(Chapter5Application.class, args);
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
