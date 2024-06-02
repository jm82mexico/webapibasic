package com.juanchi.grupos.api.grupos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class GruposApplication {

	public static void main(String[] args) {
		SpringApplication.run(GruposApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Grupos API")
				.version("1.0")
				.description("API para la gestión de grupos de usuarios")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org"))
				
				.contact(new Contact().name("Juan Carlos").email("jmdelan2012@gmail.com").url("juanchi.com.ar")));
	}

}
