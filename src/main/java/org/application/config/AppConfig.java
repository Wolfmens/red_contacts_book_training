package org.application.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@ComponentScan("org.application")
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
}
