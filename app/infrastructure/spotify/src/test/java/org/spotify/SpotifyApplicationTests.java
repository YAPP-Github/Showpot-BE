package org.spotify;

import org.junit.jupiter.api.Test;
import org.spotify.config.SpotifyConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {SpotifyConfig.class})
class SpotifyApplicationTests {

    @Test
    void contextLoads() {
    }
}
