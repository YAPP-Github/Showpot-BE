package com.example.pub.message;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowRelationArtistAndGenreServiceMessage(
    UUID showId,
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public static ShowRelationArtistAndGenreServiceMessage of(
        UUID showId,
        List<UUID> artistIds,
        List<UUID> genreIds
    ) {
        return ShowRelationArtistAndGenreServiceMessage.builder()
            .showId(showId)
            .artistIds(artistIds)
            .genreIds(genreIds)
            .build();
    }

}
