package com.example.directors_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DirectorsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectorsApiApplication.class, args);
	}

}
