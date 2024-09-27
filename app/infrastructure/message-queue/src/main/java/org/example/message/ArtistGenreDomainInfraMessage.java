package org.example.message;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.port.dto.request.ArtistDomainPortRequest;

@Builder
public record ArtistGenreDomainInfraMessage(

    UUID id,
    String name,
    String image,
    String spotifyId,
    List<String> genres
) {

    public static ArtistGenreDomainInfraMessage from(ArtistDomainPortRequest request) {
        return ArtistGenreDomainInfraMessage.builder()
            .id(request.id())
            .name(request.name())
            .image(request.image())
            .spotifyId(request.spotifyId())
            .genres(request.genres())
            .build();
    }

}
