package com.koushikreddy.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "Cards microservice REST API Documentation", description = "EazyBank Cards microservice REST API Documentation", version = "v1", contact = @Contact(name = "Koushik Reddy Gajjala", email = "koushikreddy2124@gmail.com", url = "https://www.koushikreddy.com"), license = @License(name = "Apache 2.0", url = "https://www.koushikreddy.com")), externalDocs = @ExternalDocumentation(description = "EazyBank Cards Microservice REST API Documentation", url = "https://www.koushikreddy.com"))
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
