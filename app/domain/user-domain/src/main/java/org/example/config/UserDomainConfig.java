package org.example.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "org.example")
@EntityScan(basePackages = "org.example.entity")
@EnableJpaRepositories(basePackages = {
    "org.example.repository.user",
    "org.example.repository.admin",
    "org.example.repository.subscription"
})
public class UserDomainConfig {

}
