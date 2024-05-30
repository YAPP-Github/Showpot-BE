package org.example.config;

import org.example.property.TokenProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(UserApiConfig.class)
@EnableConfigurationProperties(TokenProperty.class)
@ComponentScan(basePackages = "org.example")
public class ApiConfig {

}
