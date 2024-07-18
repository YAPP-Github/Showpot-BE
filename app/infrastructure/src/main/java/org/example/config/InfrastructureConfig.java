package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RedisConfig.class, S3Config.class})
public class InfrastructureConfig {

}
