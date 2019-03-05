package com.olegtaranenko.udemy.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.olegtaranenko")
public class PetClinicApplication {

	public static void main(String[] args) {
		System.out.println("start...");
		SpringApplication.run(PetClinicApplication.class, args);
	}

}
