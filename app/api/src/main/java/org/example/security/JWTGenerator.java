package org.example.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.example.property.TokenProperty;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTGenerator {

    private final TokenProperty tokenProperty;

    public TokenParam generate(UserParam userParam, Date from) {
        return TokenParam.builder()
            .accessToken(createAccessToken(userParam, from))
            .refreshToken(createRefreshToken(userParam, from))
            .build();
    }

    private String createAccessToken(UserParam userParam, Date from) {
        return JWT.create().withSubject("AccessToken")
            .withClaim("claim", userParam.getTokenClaim())
            .withExpiresAt(
                new Date(from.getTime() + tokenProperty.accessTokenExpirationSeconds())
            ).sign(Algorithm.HMAC512(tokenProperty.secretKey()));
    }

    private String createRefreshToken(UserParam userParam, Date from) {
        return JWT.create().withSubject("RefreshToken")
            .withClaim("claim", userParam.getTokenClaim())
            .withExpiresAt(
                new Date(from.getTime() + tokenProperty.refreshTokenExpirationSeconds())
            ).sign(Algorithm.HMAC512(tokenProperty.secretKey()));
    }
}
