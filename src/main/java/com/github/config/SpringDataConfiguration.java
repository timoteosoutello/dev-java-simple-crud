package com.github.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

/**
 * Enables to set to page = 1 as initial configuration
 * @author Timóteo Soutello
 *
 */
@Configuration
public class SpringDataConfiguration {

	@Bean
	public PageableHandlerMethodArgumentResolverCustomizer customize() {
		return p -> p.setOneIndexedParameters(true);
	}
}
