package com.tpdbd.cardpurchases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.springframework.boot.WebApplicationType.SERVLET;

@SpringBootApplication
public class CardpurchasesApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplicationBuilder(CardpurchasesApplication.class)
				.web(SERVLET)
				.build();
		app.run(args);
	}

}
