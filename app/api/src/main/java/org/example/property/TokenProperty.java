package org.example.property;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "token")
public record TokenProperty(
    String secretKey,
    Long accessTokenExpirationSeconds,
    Long refreshTokenExpirationSeconds
) {

    public SecretKey getBase64URLSecretKey() {
        return Keys.hmacShaKeyFor(
            Decoders.BASE64URL.decode(secretKey)
        );
    }
}
