package org.example.config;

import org.example.property.RedisProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RedisProperty.class)
@ComponentScan(basePackages = "org.example")
public class InfrastructureConfig {

}
