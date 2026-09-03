package com.unipi.e16095_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.unipi.e16095_assignment.controllers",
		"com.unipi.e16095_assignment.services",
		"com.unipi.e16095_assignment.repositories"
})
public class E16095AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(E16095AssignmentApplication.class, args);
	}

}
