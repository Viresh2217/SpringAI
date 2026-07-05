package com.spring.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.spring.ai.repository")
@EntityScan(basePackages = "com.spring.ai.entity")
public class HelpDeskProject {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskProject.class, args);
		System.out.println("Application is running....");
	}

}
