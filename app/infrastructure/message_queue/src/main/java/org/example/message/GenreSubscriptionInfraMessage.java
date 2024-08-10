package org.example.message;

import com.example.mq.message.GenreSubscriptionServiceMessage;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreSubscriptionInfraMessage(
    UUID userId,
    UUID genreId
) {

    public static GenreSubscriptionInfraMessage from(
        GenreSubscriptionServiceMessage message
    ) {
        return GenreSubscriptionInfraMessage.builder()
            .userId(message.userId())
            .genreId(message.genreId())
            .build();
    }
}
