package org.example.repository;

import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public final void save(String userId, String refreshToken) {
        redisTemplate.opsForValue().set("userId:" + userId, refreshToken, 14, TimeUnit.DAYS);
    }

}
