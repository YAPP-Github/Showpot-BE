package org.example.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// swagger 접속 url -> http://localhost:8080/swagger-ui/index.html#/

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .components(new Components())
            .info(getInfo());
    }

    private Info getInfo() {
        return new Info().title("YAPP BACK-END API")
            .description("공연 정보 제공 및 공유 서비스")
            .version("v0.0.1")
            .license(getLicense());
    }

    private License getLicense() {
        return new License()
            .name("Apache 2.0")
            .url("http://springdoc.org");
    }
}

