package com.example.show.service.dto.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record SubscriptionMessageServiceRequest(
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public static SubscriptionMessageServiceRequest of(List<UUID> artistIds, List<UUID> genreIds) {
        return SubscriptionMessageServiceRequest.builder()
            .artistIds(artistIds)
            .genreIds(genreIds)
            .build();
    }

}
