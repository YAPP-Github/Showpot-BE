package com.example.pub.message;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistSubscriptionServiceMessage(
    String userFcmToken,
    List<ArtistServiceMessage> artists
) {

    public static ArtistSubscriptionServiceMessage from(
        String userFcmToken,
        List<ArtistServiceMessage> artists
    ) {
        return ArtistSubscriptionServiceMessage.builder()
            .userFcmToken(userFcmToken)
            .artists(artists)
            .build();
    }
}
