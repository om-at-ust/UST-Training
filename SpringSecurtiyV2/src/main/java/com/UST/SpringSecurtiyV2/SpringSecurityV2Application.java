package com.UST.SpringSecurtiyV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringSecurityV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityV2Application.class, args);
	}

}
