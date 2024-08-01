package org.example.fixture;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.entity.ArtistSubscription;

public class ArtistSubscriptionFixture {

    public static List<ArtistSubscription> artistSubscriptions(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> ArtistSubscription.builder()
                .artistId(UUID.randomUUID())
                .userId(UUID.randomUUID())
                .build())
            .toList();
    }
}
