package org.example.fixture.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.entity.artist.Artist;
import org.example.fixture.ReflectionUtils;

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
            .mapToObj(i ->
                 Artist.builder()
                    .name("testEnglishName" + i)
                    .image("testImage" + i)
                    .spotifyId("spotifyId" + i)
                    .build()
            )
            .toList();
    }

    public static List<Artist> manSoloArtistsSetId(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> {
                Artist artist = Artist.builder()
                    .name("testEnglishName" + i)
                    .image("testImage" + i)
                    .spotifyId("spotifyId" + i)
                    .build();
                ReflectionUtils.setSuperClassId(
                    artist,
                    "id",
                    UUID.fromString("019217fe-2277-9fcf-26fd-90d22a5374d6")
                );
                return artist;
            })
            .toList();
    }
}
