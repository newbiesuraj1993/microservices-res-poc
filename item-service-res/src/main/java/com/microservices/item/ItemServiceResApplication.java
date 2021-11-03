package com.microservices.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItemServiceResApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceResApplication.class, args);
	}

}
