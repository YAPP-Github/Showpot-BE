package org.example.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import java.util.Date;
import java.util.UUID;
import org.example.property.TokenProperty;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.example.security.token.JWTGenerator;
import org.example.vo.UserRoleApiType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JWTGeneratorTest {

    long hour = 3600000L;
    long twoWeeks = 1209600000L;

    TokenProperty tokenProperty = new TokenProperty(
        "wehfiuhewiuhfhweiuhfiuwehifueiuwhfiuw",
        hour,
        twoWeeks
    );

    JWTGenerator tokenGenerator = new JWTGenerator(tokenProperty);
    UserParam userParam = new UserParam(
        UUID.randomUUID(),
        UserRoleApiType.USER
    );

    @Test
    @DisplayName("1시간 전에 생성된 AccessToken은 유효하지 않다.")
    void accessTokenInvalidBeforeHourAgo() {
        Date beforeHour = new Date(new Date().getTime() - hour);
        TokenParam token = tokenGenerator.generate(userParam, beforeHour);

        Assertions.assertThrowsExactly(
            TokenExpiredException.class,
            () -> JWT.require(Algorithm.HMAC512(tokenProperty.secretKey()))
                .build()
                .verify(token.accessToken())
        );
    }

    @Test
    @DisplayName("1시간 내에 생성된 AccessToken은 유효하다.")
    void accessTokenValidAfterHourAgo() {
        long second = 1000L;
        Date beforeHourPlusSecond = new Date(new Date().getTime() - hour + second);
        TokenParam token = tokenGenerator.generate(userParam, beforeHourPlusSecond);

        Assertions.assertDoesNotThrow(
            () -> JWT.require(Algorithm.HMAC512(tokenProperty.secretKey()))
                .build()
                .verify(token.accessToken())
        );
    }

    @Test
    @DisplayName("2주 전에 생성된 RefreshToken은 유효하지 않다.")
    void refreshTokenInvalidBeforeHourAgo() {
        Date beforeTwoWeeks = new Date(new Date().getTime() - twoWeeks);
        TokenParam token = tokenGenerator.generate(userParam, beforeTwoWeeks);

        Assertions.assertThrowsExactly(
            TokenExpiredException.class,
            () -> JWT.require(Algorithm.HMAC512(tokenProperty.secretKey()))
                .build()
                .verify(token.refreshToken())
        );
    }

    @Test
    @DisplayName("2주 내에 생성된 RefreshToken은 유효하다.")
    void refreshTokenValidAfterHourAgo() {
        long second = 1000L;
        Date beforeTwoWeeksPlusSecond = new Date(new Date().getTime() - twoWeeks + second);
        TokenParam token = tokenGenerator.generate(userParam, beforeTwoWeeksPlusSecond);

        Assertions.assertDoesNotThrow(
            () -> JWT.require(Algorithm.HMAC512(tokenProperty.secretKey()))
                .build()
                .verify(token.refreshToken())
        );
    }
}