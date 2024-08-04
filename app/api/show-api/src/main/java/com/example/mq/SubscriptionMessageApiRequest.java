package com.example.mq;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record SubscriptionMessageApiRequest(
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public static SubscriptionMessageApiRequest of(List<UUID> artistIds, List<UUID> genreIds) {
        return SubscriptionMessageApiRequest.builder()
            .artistIds(artistIds)
            .genreIds(genreIds)
            .build();
    }

}
