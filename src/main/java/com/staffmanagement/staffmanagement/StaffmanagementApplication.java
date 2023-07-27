package com.staffmanagement.staffmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.staffmanagement.staffmanagement.config.ContentProperties;

@EnableConfigurationProperties(ContentProperties.class)
@SpringBootApplication
public class StaffmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffmanagementApplication.class, args);
	}

}
