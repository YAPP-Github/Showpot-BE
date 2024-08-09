package com.example.mq.message;

import java.util.UUID;
import lombok.Builder;
import org.example.entity.ArtistSubscription;

@Builder
public record ArtistSubscriptionServiceMessage(
    UUID userId,
    UUID artistId
) {
    public static ArtistSubscriptionServiceMessage from(ArtistSubscription artistSubscription) {
        return ArtistSubscriptionServiceMessage.builder()
            .userId(artistSubscription.getUserId())
            .artistId(artistSubscription.getArtistId())
            .build();
    }
}
