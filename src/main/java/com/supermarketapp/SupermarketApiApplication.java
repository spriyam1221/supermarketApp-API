package com.supermarketapp;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupermarketApiApplication {
 
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SupermarketApiApplication.class, args);
		System.out.println("priya");
	}

}
