package com.example.artist.sub.message;

import com.example.artist.service.dto.request.ArtistDomainServiceRequest;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistDomainMessageRequest(
    UUID id,
    String name,
    String image,
    String spotifyId,
    List<String> genres
) {
    public ArtistDomainServiceRequest toServiceRequest() {
        return ArtistDomainServiceRequest.builder()
            .id(id)
            .name(name)
            .image(image)
            .spotifyId(spotifyId)
            .genres(genres)
            .build();
    }

}
