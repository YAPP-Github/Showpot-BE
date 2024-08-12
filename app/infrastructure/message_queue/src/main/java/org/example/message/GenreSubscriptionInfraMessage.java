package org.example.message;

import com.example.mq.message.GenreSubscriptionServiceMessage;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreSubscriptionInfraMessage(
    String userFcmToken,
    List<UUID> genreIds
) {

    public static GenreSubscriptionInfraMessage from(
        GenreSubscriptionServiceMessage message
    ) {
        return GenreSubscriptionInfraMessage.builder()
            .userFcmToken(message.userFcmToken())
            .genreIds(message.genreIds())
            .build();
    }
}
