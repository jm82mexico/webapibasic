package com.juanchi.grupos.api.grupos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
@PropertySource("classpath:messages.properties")
public class AppConfig {

    @Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Grupos API")
				.version("1.0")
				.description("API para la gestión de grupos de usuarios")				
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
			
}
