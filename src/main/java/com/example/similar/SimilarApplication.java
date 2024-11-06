package com.example.similar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class SimilarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimilarApplication.class, args);
	}

}
