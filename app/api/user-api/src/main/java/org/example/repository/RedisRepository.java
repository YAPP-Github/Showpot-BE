package org.example.repository;

import org.springframework.stereotype.Component;

@Component
public interface RedisRepository {

    void save(String userId, String refreshToken);
}
