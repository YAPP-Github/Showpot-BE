package org.example.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.property.TokenProperty;
import org.example.security.vo.TokenError;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTProcessor {

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

    public DecodedJWT decodeToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(tokenProperty.secretKey()))
                .build()
                .verify(token);
        } catch (TokenExpiredException e) {
            throw new BusinessException(TokenError.EXPIRED_TOKEN);
        } catch (Exception e) {
            throw new BusinessException(TokenError.INVALID_TOKEN);
        }
    }
}
