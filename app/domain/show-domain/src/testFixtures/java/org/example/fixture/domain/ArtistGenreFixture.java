package org.example.fixture.domain;

import java.util.UUID;
import org.example.entity.artist.ArtistGenre;

public class ArtistGenreFixture {

    public static ArtistGenre artistGenre(
        UUID artistId,
        UUID genreId
    ) {
        return ArtistGenre.builder()
            .artistId(artistId)
            .genreId(genreId)
            .build();
    }

}
