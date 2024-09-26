package org.example.dto.artist.request;

import java.util.UUID;
import lombok.Builder;
import org.example.entity.artist.Artist;

@Builder
public record ArtistGenreDomainRequest(
    UUID artistId,
    String name,
    String image,
    String spotifyId,
    String genreName
) {

    public Artist toArtist() {
        return Artist.builder()
            .name(name)
            .image(image)
            .spotifyId(spotifyId)
            .build()
            .changeId(artistId);
    }


}
