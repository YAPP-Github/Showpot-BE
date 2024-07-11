package org.example.config;

import org.example.property.S3Property;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(S3Property.class)
@ComponentScan(basePackages = {"org.example", "org.example.config"})
public class S3BeanConfig {

}
