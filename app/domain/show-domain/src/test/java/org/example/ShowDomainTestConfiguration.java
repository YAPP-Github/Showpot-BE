package org.example;

import org.example.config.ShowDomainConfig;
import org.example.fixture.port.ArtistSearchPortFixture;
import org.example.port.ArtistSearchPort;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {ShowDomainConfig.class})
public class ShowDomainTestConfiguration {

    @Bean
    public ArtistSearchPort artistSearchPort() {
        return new ArtistSearchPortFixture();
    }
}
