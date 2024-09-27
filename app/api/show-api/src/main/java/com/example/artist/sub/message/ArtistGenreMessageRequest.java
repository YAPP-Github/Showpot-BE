package com.example.artist.sub.message;

import com.example.artist.service.dto.request.ArtistGenreServiceRequest;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistGenreMessageRequest(
    UUID id,
    String name,
    String image,
    String spotifyId,
    List<String> genres
) {
    public ArtistGenreServiceRequest toServiceRequest() {
        return ArtistGenreServiceRequest.builder()
            .artistId(id)
            .name(name)
            .image(image)
            .spotifyId(spotifyId)
            .genres(genres)
            .build();
    }

}
