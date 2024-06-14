package org.example.repository;

import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LettuceRedisRepository implements RedisRepository {

    private final StringRedisTemplate stringRedisTemplate;

    public void save(String userId, String refreshToken) {
        stringRedisTemplate.opsForValue().set("userId:" + userId, refreshToken, 14, TimeUnit.DAYS);
    }

}
