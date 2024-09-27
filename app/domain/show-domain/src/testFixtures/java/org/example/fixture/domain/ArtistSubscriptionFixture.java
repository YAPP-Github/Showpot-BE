package org.example.fixture.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.entity.usershow.ArtistSubscription;
import org.example.fixture.ReflectionUtils;

public class ArtistSubscriptionFixture {

    public static List<ArtistSubscription> artistSubscriptions(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> {
                ArtistSubscription artistSubscription = ArtistSubscription.builder()
                    .artistId(UUID.randomUUID())
                    .userId(UUID.randomUUID())
                    .build();
                ReflectionUtils.setId(
                    artistSubscription,
                    "artistId",
                    UUID.fromString("019217fe-2277-9fcf-26fd-90d22a5374d6")
                );
                return artistSubscription;
            })
            .toList();
    }
}
