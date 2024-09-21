package org.spotify.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spotify")
public record SpotifyProperty(
    String clientId,
    String clientSecret,
    String tokenApiURL,
    String apiURL
) {

}
