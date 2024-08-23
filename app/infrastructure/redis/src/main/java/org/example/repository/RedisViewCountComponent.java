package org.example.repository;

import com.example.component.ViewCountComponent;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisViewCountComponent implements ViewCountComponent {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean validateViewCount(UUID showId, String viewIdentifier) {
        String viewStatus = stringRedisTemplate.opsForValue().get("VC:" + viewIdentifier + showId);

        if (viewStatus == null) {
            stringRedisTemplate.opsForValue()
                .set("VC:" + viewIdentifier + showId, "1", 30, TimeUnit.MINUTES);
            return true;
        }

        return false;
    }
}
