package org.example.message;

import com.example.mq.message.ArtistSubscriptionServiceMessage;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistSubscriptionInfraMessage(
    String userFcmToken,
    List<UUID> artistIds
) {

    public static ArtistSubscriptionInfraMessage from(
        ArtistSubscriptionServiceMessage message
    ) {
        return ArtistSubscriptionInfraMessage.builder()
            .userFcmToken(message.userFcmToken())
            .artistIds(message.artistIds())
            .build();
    }
}
