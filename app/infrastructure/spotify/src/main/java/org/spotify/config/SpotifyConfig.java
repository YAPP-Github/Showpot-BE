package org.spotify.config;

import org.spotify.property.SpotifyProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({SpotifyProperty.class})
public class SpotifyConfig {

}
