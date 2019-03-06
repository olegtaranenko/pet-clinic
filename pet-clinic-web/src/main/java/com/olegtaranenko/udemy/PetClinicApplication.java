package com.olegtaranenko.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
/*
 * TODO possible bug in the Spring Framework
 * Initial disposition:
 * 	pet-clinic-web was defined in the com.olegtaranenko.udemy.petclinic package
 * 	pet-clinic-data was defined in the com.olegtaranenko.udemy package
 * 	Then by default PetClinicApplication have to add annotation (basePackages = "com.olegtaranenko.udemy")
 *
 * 	But! this was follow, that at runtime I got an not satisfied bean resolution under the "springdatajpa" active profile.
 * 	Was really curious, because with "map" active profile there was all OK
 *
 * 	Fix: renaming com.olegtaranenko.udemy.petclinic => com.olegtaranenko.udemy
 *  Annotation is not required now
 */
//@ComponentScan(basePackages = "com.olegtaranenko.udemy")

public class PetClinicApplication {

	public static void main(String[] args) {
		System.out.println("start...");
		SpringApplication.run(PetClinicApplication.class, args);
	}

}
