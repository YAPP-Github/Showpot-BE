package org.example.message;

import com.example.publish.message.GenreSubscriptionServiceMessage;
import java.util.List;
import lombok.Builder;

@Builder
public record GenreSubscriptionInfraMessage(
    String userFcmToken,
    List<GenreInfraMessage> genres
) {

    public static GenreSubscriptionInfraMessage from(
        GenreSubscriptionServiceMessage message
    ) {
        return GenreSubscriptionInfraMessage.builder()
            .userFcmToken(message.userFcmToken())
            .genres(message.genres().stream().map(GenreInfraMessage::from).toList())
            .build();
    }
}
