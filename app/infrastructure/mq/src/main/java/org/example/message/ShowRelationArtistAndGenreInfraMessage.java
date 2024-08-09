package org.example.message;

import com.example.show.service.dto.request.ShowRelationArtistAndGenreServiceMessage;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowRelationArtistAndGenreInfraMessage(
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public static ShowRelationArtistAndGenreInfraMessage from(
        ShowRelationArtistAndGenreServiceMessage message
    ) {
        return ShowRelationArtistAndGenreInfraMessage.builder()
            .artistIds(message.artistIds())
            .genreIds(message.genreIds())
            .build();

    }
}
