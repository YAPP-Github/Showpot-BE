package org.example.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private final String securitySchemeName = "JWT Authorization";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(getInfo())
            .addServersItem(getCurrentServerUrl())
            .addSecurityItem(getSecurityRequirement())
            .components(
                new Components().addSecuritySchemes(
                    securitySchemeName,
                    getSecurityScheme()
                )
            );
    }

    private Info getInfo() {
        return new Info().title("YAPP BACK-END API")
            .description("공연 정보 제공 및 공유 서비스")
            .version("v0.0.1")
            .license(getLicense());
    }

    private Server getCurrentServerUrl() {
        return new Server().url("/");
    }

    private SecurityRequirement getSecurityRequirement() {
        return new SecurityRequirement().addList(securitySchemeName);
    }

    private SecurityScheme getSecurityScheme() {
        return new SecurityScheme()
            .name(securitySchemeName)
            .type(SecurityScheme.Type.HTTP)
            .in(SecurityScheme.In.HEADER)
            .scheme("Bearer")
            .bearerFormat("JWT");
    }

    private License getLicense() {
        return new License()
            .name("Apache 2.0")
            .url("http://springdoc.org");
    }
}

