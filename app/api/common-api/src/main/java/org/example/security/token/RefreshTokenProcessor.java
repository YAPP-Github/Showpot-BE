package org.example.security.token;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.exception.BusinessException;
import org.example.repository.TokenRepository;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.example.security.vo.TokenError;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefreshTokenProcessor {

    private final JWTHandler jwtHandler;
    private final JWTGenerator jwtGenerator;
    private final TokenRepository tokenRepository;

    public TokenParam reissueToken(HttpServletRequest request) {
        String refreshToken = jwtHandler.extractRefreshToken(request);
        UserParam userParam = jwtHandler.extractUserFrom(refreshToken);

        String oldRefreshToken = jwtGenerator.getExistRefreshToken(userParam);
        if (!refreshToken.equals(oldRefreshToken)) {
            throw new BusinessException(TokenError.INVALID_TOKEN);
        }

        return jwtGenerator.generate(userParam, new Date());
    }

    public void deleteRefreshToken(UUID userId) {
        tokenRepository.delete(userId);
    }
}
