package org.example.message;

import com.example.pub.message.ArtistSubscriptionServiceMessage;
import java.util.List;
import lombok.Builder;

@Builder
public record ArtistSubscriptionInfraMessage(
    String userFcmToken,
    List<ArtistInfraMessage> artists
) {

    public static ArtistSubscriptionInfraMessage from(
        ArtistSubscriptionServiceMessage message
    ) {
        return ArtistSubscriptionInfraMessage.builder()
            .userFcmToken(message.userFcmToken())
            .artists(message.artists().stream().map(ArtistInfraMessage::from).toList())
            .build();
    }
}
