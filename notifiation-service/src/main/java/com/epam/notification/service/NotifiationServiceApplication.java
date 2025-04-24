package com.epam.notification.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NotifiationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifiationServiceApplication.class, args);
	}

}
