package com.services.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
@EnableEurekaClient
@SpringBootApplication
//@ComponentScan("com.services.*")
public class StockserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockserviceApplication.class, args);
	}
}
