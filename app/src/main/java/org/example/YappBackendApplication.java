package org.example;

import org.example.config.ApiConfig;
import org.example.config.InfrastructureConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {ApiConfig.class, InfrastructureConfig.class})
public class YappBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(YappBackendApplication.class, args);
    }
}
