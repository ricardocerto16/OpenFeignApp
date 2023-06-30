package com.example.consemefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsemeFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsemeFeignApplication.class, args);
	}

}
