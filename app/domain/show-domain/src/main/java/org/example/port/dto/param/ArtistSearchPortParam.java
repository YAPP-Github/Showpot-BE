package org.example.port.dto.param;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistSearchSimpleDomainResponse;
import org.example.entity.artist.Artist;
import org.example.port.dto.request.ArtistDomainPortRequest;

@Builder
public record ArtistSearchPortParam(
    String id,
    String name,
    List<String> genres,
    String imageURL
) {

    public ArtistSearchSimpleDomainResponse toDomainResponse(Artist artist) {
        return ArtistSearchSimpleDomainResponse.builder()
            .id(artist != null ? artist.getId() : null)
            .name(name)
            .image(imageURL)
            .spotifyId(id)
            .build();
    }

    public Artist toArtist() {
        return Artist.builder()
            .name(name)
            .spotifyId(id)
            .image(imageURL)
            .build();
    }

    public ArtistDomainPortRequest toDomainRequest(UUID artistId) {
        return ArtistDomainPortRequest.builder()
            .id(artistId)
            .name(name)
            .image(imageURL)
            .genres(genres)
            .spotifyId(id)
            .build();
    }
}
