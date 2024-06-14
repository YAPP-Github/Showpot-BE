package org.example.repository;

import org.springframework.stereotype.Component;

@Component
public interface TokenRepository {

    void save(String userId, String refreshToken);

    String getOldRefreshToken(String userId);
}
