package com.example.mq.message;

import java.util.UUID;
import lombok.Builder;
import org.example.entity.GenreSubscription;

@Builder
public record GenreSubscriptionServiceMessage(
    UUID userId,
    UUID genreId
) {

    public static GenreSubscriptionServiceMessage from(GenreSubscription genreSubscription) {
        return GenreSubscriptionServiceMessage.builder()
            .userId(genreSubscription.getUserId())
            .genreId(genreSubscription.getGenreId())
            .build();
    }
}
