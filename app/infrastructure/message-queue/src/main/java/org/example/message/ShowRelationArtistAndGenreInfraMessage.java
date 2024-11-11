package org.example.message;

import com.example.pub.message.ShowRelationArtistAndGenreServiceMessage;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowRelationArtistAndGenreInfraMessage(
    UUID showId,
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public static ShowRelationArtistAndGenreInfraMessage from(
        ShowRelationArtistAndGenreServiceMessage message
    ) {
        return ShowRelationArtistAndGenreInfraMessage.builder()
            .showId(message.showId())
            .artistIds(message.artistIds())
            .genreIds(message.genreIds())
            .build();

    }
}
