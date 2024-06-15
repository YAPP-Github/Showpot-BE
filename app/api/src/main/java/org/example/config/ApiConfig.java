package org.example.config;

import com.example.config.ArtistApiConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({UserApiConfig.class, ArtistApiConfig.class})
public class ApiConfig {

}
