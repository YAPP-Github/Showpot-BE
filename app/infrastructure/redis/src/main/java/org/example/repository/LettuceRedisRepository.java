package org.example.repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LettuceRedisRepository implements TokenRepository {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void save(String userId, String refreshToken) {
        stringRedisTemplate.opsForValue().set("RT:" + userId, refreshToken, 14, TimeUnit.DAYS);
    }

    @Override
    public Optional<String> getExistRefreshToken(String userId) {
        return Optional.ofNullable(stringRedisTemplate.opsForValue().get("RT:" + userId));
    }

    @Override
    public Boolean existAccessToken(String userId) {
        return stringRedisTemplate.hasKey("AT:" + userId);
    }

}
