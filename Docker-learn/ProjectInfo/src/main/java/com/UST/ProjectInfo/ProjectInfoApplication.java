package com.UST.ProjectInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProjectInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectInfoApplication.class, args);
	}

}
