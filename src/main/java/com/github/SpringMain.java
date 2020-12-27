package com.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Spring initialization class
 * 
 * @author Timóteo Soutello
 *
 */
@SpringBootApplication
@EnableRetry
public class SpringMain extends SpringBootServletInitializer {
  public static void main(final String[] args) {
    SpringApplication.run(SpringMain.class, args);
  }
}
