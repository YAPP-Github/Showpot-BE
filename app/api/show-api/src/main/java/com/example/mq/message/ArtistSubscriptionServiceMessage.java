package com.example.mq.message;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistSubscriptionServiceMessage(
    String userFcmToken,
    List<UUID> artistIds
) {

    public static ArtistSubscriptionServiceMessage from(
        String userFcmToken,
        List<UUID> artistIds
    ) {
        return ArtistSubscriptionServiceMessage.builder()
            .userFcmToken(userFcmToken)
            .artistIds(artistIds)
            .build();
    }
}
