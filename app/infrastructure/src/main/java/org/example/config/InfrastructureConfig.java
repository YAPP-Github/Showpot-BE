package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RedisBeanConfig.class, S3BeanConfig.class})
public class InfrastructureConfig {

}
