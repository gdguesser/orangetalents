package com.orangetalents.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class OrangeTalentsApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrangeTalentsApplication.class, args);
	}
}
