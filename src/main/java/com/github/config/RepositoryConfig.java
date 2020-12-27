package com.github.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.github.model.Profile;
import com.github.model.User;

/**
 * Repository spring data configuration.
 * 
 * @author Timóteo Soutello
 */
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
  @Override
  public void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config) {
    config.exposeIdsFor(Profile.class);
    config.exposeIdsFor(User.class);
  }
}
