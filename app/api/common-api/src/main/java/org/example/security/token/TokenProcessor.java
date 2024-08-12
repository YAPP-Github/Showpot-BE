package org.example.security.token;

import java.util.Date;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.exception.BusinessException;
import org.example.repository.TokenRepository;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.example.security.error.TokenError;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenProcessor {

    private final JWTHandler jwtHandler;
    private final JWTGenerator jwtGenerator;
    private final TokenRepository tokenRepository;

    public TokenParam reissueToken(String refreshToken) {
        UserParam userParam = jwtHandler.extractUserFrom(refreshToken);

        String oldRefreshToken = getExistRefreshToken(userParam);
        if (!refreshToken.equals(oldRefreshToken)) {
            throw new BusinessException(TokenError.INVALID_TOKEN);
        }

        return jwtGenerator.generate(userParam, new Date());
    }

    public void verifyAccessTokenBlacklist(UserParam userParam, String accessKey) {
        if (tokenRepository.existAccessTokenInBlacklist(userParam.userId(), accessKey)) {
            throw new BusinessException(TokenError.BLACKLIST_ACCESS_TOKEN);
        }
    }

    public void makeAccessTokenBlacklistAndDeleteRefreshToken(
        String accessToken,
        UUID userId
    ) {
        tokenRepository.saveBlacklistAccessToken(userId, accessToken);
        tokenRepository.deleteRefreshToken(userId);
    }

    private String getExistRefreshToken(UserParam userParam) {
        return tokenRepository.getExistRefreshToken(userParam.userId().toString())
            .orElseThrow(() -> new BusinessException(TokenError.WRONG_HEADER));
    }
}
