package org.example.adapter.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.port.dto.request.ArtistDomainPortRequest;

@Builder
public record ArtistDomainInfraRequest(

    UUID id,
    String name,
    String image,
    String spotifyId,
    List<String> genres
) {

    public static ArtistDomainInfraRequest from(ArtistDomainPortRequest request) {
        return ArtistDomainInfraRequest.builder()
            .id(request.id())
            .name(request.name())
            .image(request.image())
            .spotifyId(request.spotifyId())
            .genres(request.genres())
            .build();
    }

}
