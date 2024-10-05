package com.UST.EmployeeInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeInfoApplication.class, args);
	}

}
