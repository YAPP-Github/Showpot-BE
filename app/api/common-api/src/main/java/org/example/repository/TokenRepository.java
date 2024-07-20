package org.example.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public interface TokenRepository {

    void saveBlacklistAccessToken(UUID userId, String accessToken);

    void saveRefreshToken(UUID userId, String refreshToken);

    Optional<String> getExistRefreshToken(String userId);

    boolean existAccessTokenInBlacklist(UUID userId, String accessToken);

    void deleteRefreshToken(UUID userId);
}
