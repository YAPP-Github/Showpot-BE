package com.example.mq.message;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreSubscriptionServiceMessage(
    String userFcmToken,
    List<UUID> genreIds
) {

    public static GenreSubscriptionServiceMessage from(
        String userFcmToken,
        List<UUID> genreIds
    ) {
        return GenreSubscriptionServiceMessage.builder()
            .userFcmToken(userFcmToken)
            .genreIds(genreIds)
            .build();
    }
}
