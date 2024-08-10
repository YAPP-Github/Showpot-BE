package org.example.message;

import com.example.mq.message.ArtistSubscriptionServiceMessage;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistSubscriptionInfraMessage(
    UUID userId,
    UUID artistId
) {

    public static ArtistSubscriptionInfraMessage from(
        ArtistSubscriptionServiceMessage message
    ) {
        return ArtistSubscriptionInfraMessage.builder()
            .userId(message.userId())
            .artistId(message.artistId())
            .build();
    }
}
