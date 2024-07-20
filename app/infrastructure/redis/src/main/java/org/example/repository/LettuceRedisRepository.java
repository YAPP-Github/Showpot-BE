package org.example.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LettuceRedisRepository implements TokenRepository {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void saveBlacklistAccessToken(UUID userId, String accessToken) {
        stringRedisTemplate.opsForValue()
            .set("AT:" + accessToken, userId.toString(), 14, TimeUnit.DAYS);
    }

    @Override
    public void saveRefreshToken(String userId, String refreshToken) {
        stringRedisTemplate.opsForValue()
            .set("RT:" + userId, refreshToken, 14, TimeUnit.DAYS);
    }

    @Override
    public Optional<String> getExistRefreshToken(String userId) {
        return Optional.ofNullable(stringRedisTemplate.opsForValue().get("RT:" + userId));
    }

    @Override
    public boolean existAccessToken(UUID userId, String accessToken) {
        String existAccessKey = stringRedisTemplate.opsForValue().get("AT:" + accessToken);
        if (existAccessKey == null) {
            return false;
        }

        return existAccessKey.equals(userId.toString());
    }

    @Override
    public void delete(UUID userId) {
        stringRedisTemplate.delete("RT:" + userId);
    }
}
