package com.github.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Swagger configuration.
 * 
 * @author Timóteo Soutello
 */
@Configuration
public class SwaggerConfiguration {
	@Bean
	public OpenAPI customOpenAPI(@Value("${info.app.name}") String appName,
			@Value("${info.app.description}") String appDescription,
			@Value("${info.app.description}") String appVersion) {
		return new OpenAPI().info(new Info().title(appName).version(appVersion).description(appDescription));
	}
}
