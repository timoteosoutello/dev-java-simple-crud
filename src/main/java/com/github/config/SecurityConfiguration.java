package com.github.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String SPRING_ROLE = "ACTUATOR";

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests().antMatchers("/**").hasRole(SPRING_ROLE).and().httpBasic();
    }
}
