package org.example.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "token")
public record TokenProperty(
    String secretKey,
    Long accessTokenExpirationSeconds,
    Long refreshTokenExpirationSeconds
) {

}
