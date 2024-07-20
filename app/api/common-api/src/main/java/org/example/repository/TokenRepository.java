package org.example.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public interface TokenRepository {

    void saveBlacklistAccessToken(UUID userId, String accessToken);

    void saveRefreshToken(String userId, String refreshToken);

    Optional<String> getExistRefreshToken(String userId);

    boolean existAccessToken(UUID userId, String accessToken);

    void delete(UUID userId);
}
