package org.example.fixture;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.entity.GenreSubscription;

public class GenreSubscriptionFixture {

    public static List<GenreSubscription> genreSubscriptions(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> GenreSubscription.builder()
                .genreId(UUID.randomUUID())
                .userId(UUID.randomUUID())
                .build())
            .toList();
    }
}
