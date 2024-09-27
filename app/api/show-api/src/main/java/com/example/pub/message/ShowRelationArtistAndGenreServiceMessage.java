package com.example.pub.message;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowRelationArtistAndGenreServiceMessage(
    List<UUID> artistIds,
    List<UUID> genreIds
) {

    public static ShowRelationArtistAndGenreServiceMessage of(List<UUID> artistIds, List<UUID> genreIds) {
        return ShowRelationArtistAndGenreServiceMessage.builder()
            .artistIds(artistIds)
            .genreIds(genreIds)
            .build();
    }

}
