package com.sdc.callingapp.profilemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sdc.callingapp.profilemanagement")
public class ProfileManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileManagementApplication.class, args);
	}
}
