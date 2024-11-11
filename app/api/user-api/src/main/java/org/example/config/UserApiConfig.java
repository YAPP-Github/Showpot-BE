package org.example.config;

import org.example.property.AlarmServerProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(UserDomainConfig.class)
@EnableConfigurationProperties(AlarmServerProperty.class)
@ComponentScan(basePackages = "org.example")
public class UserApiConfig {

}
