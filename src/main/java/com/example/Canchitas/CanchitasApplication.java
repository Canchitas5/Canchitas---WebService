package com.example.Canchitas;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CanchitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanchitasApplication.class, args);
	}
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info().title("My REST"))
				.externalDocs(new ExternalDocumentation());
	}
}
