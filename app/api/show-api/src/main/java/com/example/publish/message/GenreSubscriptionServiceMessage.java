package com.example.publish.message;

import java.util.List;
import lombok.Builder;

@Builder
public record GenreSubscriptionServiceMessage(
    String userFcmToken,
    List<GenreServiceMessage> genres
) {

    public static GenreSubscriptionServiceMessage from(
        String userFcmToken,
        List<GenreServiceMessage> genres
    ) {
        return GenreSubscriptionServiceMessage.builder()
            .userFcmToken(userFcmToken)
            .genres(genres)
            .build();
    }
}
