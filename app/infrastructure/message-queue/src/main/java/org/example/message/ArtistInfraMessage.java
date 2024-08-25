package org.example.message;

import com.example.publish.message.ArtistServiceMessage;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistInfraMessage(
    UUID artistId,
    String artistName
) {

    public static ArtistInfraMessage from(ArtistServiceMessage message) {
        return ArtistInfraMessage.builder()
            .artistId(message.id())
            .artistName(message.name())
            .build();
    }
}
