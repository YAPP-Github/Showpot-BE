package org.example.security.token;

import io.jsonwebtoken.Jwts;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.example.property.TokenProperty;
import org.example.repository.TokenRepository;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTGenerator {

    private final TokenProperty tokenProperty;
    private final TokenRepository tokenRepository;

    public TokenParam generate(UserParam userParam, Date from) {
        TokenParam tokenParam = TokenParam.builder()
            .accessToken(createAccessToken(userParam, from))
            .refreshToken(createRefreshToken(userParam, from))
            .build();

        tokenRepository.saveRefreshToken(userParam.userId().toString(), tokenParam.refreshToken());
        return tokenParam;
    }

    private String createAccessToken(UserParam userParam, Date from) {
        return Jwts.builder()
            .subject("AccessToken")
            .claims(userParam.getTokenClaim())
            .expiration(
                new Date(from.getTime() + tokenProperty.accessTokenExpirationSeconds())
            )
            .signWith(tokenProperty.getBase64URLSecretKey())
            .compact();
    }

    private String createRefreshToken(UserParam userParam, Date from) {
        return Jwts.builder()
            .subject("RefreshToken")
            .claims(userParam.getTokenClaim())
            .expiration(
                new Date(from.getTime() + tokenProperty.refreshTokenExpirationSeconds())
            )
            .signWith(tokenProperty.getBase64URLSecretKey())
            .compact();
    }
}
