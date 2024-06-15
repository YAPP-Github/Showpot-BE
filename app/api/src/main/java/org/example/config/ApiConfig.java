package org.example.config;

import com.example.artistapi.controller.config.ArtistApiConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({UserApiConfig.class, ArtistApiConfig.class})
public class ApiConfig {

}
