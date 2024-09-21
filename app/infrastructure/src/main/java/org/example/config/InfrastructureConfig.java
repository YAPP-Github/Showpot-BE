package org.example.config;

import org.spotify.config.SpotifyConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RedisConfig.class, PubSubConfig.class, S3Config.class, SpotifyConfig.class})
public class InfrastructureConfig {

}
