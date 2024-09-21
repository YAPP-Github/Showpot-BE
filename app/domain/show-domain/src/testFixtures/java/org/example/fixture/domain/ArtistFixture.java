package org.example.fixture.domain;

import java.util.List;
import java.util.stream.IntStream;
import org.example.entity.artist.Artist;

public class ArtistFixture {

    public static Artist womanGroup() {
        return Artist.builder()
            .name("IVE")
            .image("abc")
            .spotifyId("spotifyId")
            .build();
    }

    public static List<Artist> manSoloArtists(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> Artist.builder()
                .name("testEnglishName" + i)
                .image("testImage" + i)
                .spotifyId("spotifyId" + i)
                .build()
            )
            .toList();
    }
}
