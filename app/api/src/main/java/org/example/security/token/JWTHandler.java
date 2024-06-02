package org.example.security.token;

import org.example.exception.BusinessException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.property.TokenProperty;
import org.example.security.dto.UserParam;
import org.example.security.vo.TokenError;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTHandler {

    private final TokenProperty tokenProperty;

    public String extractAccessToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        if (!authorization.startsWith("Bearer ")) {
            throw new BusinessException(TokenError.WRONG_HEADER);
        }

        return authorization.replace("Bearer ", "");
    }

    public String extractRefreshToken(HttpServletRequest request) {
        String refresh = request.getHeader("Refresh");

        if (refresh == null) {
            throw new BusinessException(TokenError.WRONG_HEADER);
        }

        return refresh;
    }

    public UserParam extractUserFrom(String token) {
        Object payload = parsePayload(token);
        return convertPayloadToUserParam(payload);
    }

    public UUID getUserIdFromExpiredToken(String token) {
        try {
            parseToken(token);
        } catch (ExpiredJwtException e) {
            return UUID.fromString(e.getClaims().get("userId", String.class));
        }

        throw new BusinessException(TokenError.UNEXPIRED_TOKEN);
    }

    private Object parsePayload(String token) {
        try {
            return parseToken(token)
                .getPayload();
        } catch (ExpiredJwtException e) {
            throw new BusinessException(TokenError.EXPIRED_TOKEN);
        } catch (Exception e) {
            throw new BusinessException(TokenError.INVALID_TOKEN);
        }
    }

    private Jwt<?, ?> parseToken(String token) {
        return Jwts.parser()
            .verifyWith(tokenProperty.getBASE64URLSecretKey())
            .build()
            .parse(token);
    }

    private UserParam convertPayloadToUserParam(Object payload) {
        try {
            return UserParam.fromPayload(payload);
        } catch (Exception e) {
            throw new BusinessException(TokenError.INVALID_CLAIM);
        }
    }
}
