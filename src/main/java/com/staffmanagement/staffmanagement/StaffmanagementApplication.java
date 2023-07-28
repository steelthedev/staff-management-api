package com.staffmanagement.staffmanagement;

import com.staffmanagement.staffmanagement.config.RsaKeyProperties;
import com.staffmanagement.staffmanagement.models.Role;
import com.staffmanagement.staffmanagement.models.User;
import com.staffmanagement.staffmanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.staffmanagement.staffmanagement.config.ContentProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableConfigurationProperties({ContentProperties.class, RsaKeyProperties.class})
@SpringBootApplication
public class StaffmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffmanagementApplication.class, args);
	}


}
