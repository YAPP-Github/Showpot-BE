package org.example.message;

import com.example.publish.message.GenreServiceMessage;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreInfraMessage(
    UUID genreId,
    String genreName
) {

    public static GenreInfraMessage from(GenreServiceMessage message) {
        return GenreInfraMessage.builder()
            .genreId(message.id())
            .genreName(message.name())
            .build();
    }
}
