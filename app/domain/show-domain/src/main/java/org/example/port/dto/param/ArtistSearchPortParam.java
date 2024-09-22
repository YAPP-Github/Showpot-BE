package org.example.port.dto.param;

import java.util.List;
import lombok.Builder;
import org.example.dto.artist.response.ArtistSearchSimpleDomainResponse;
import org.example.entity.artist.Artist;

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
}
