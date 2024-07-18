package org.example.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public interface TokenRepository {

    void save(String userId, String refreshToken);

    Optional<String> getExistRefreshToken(String userId);

    Boolean existAccessToken(String userId);

    void delete(UUID userId);
}
