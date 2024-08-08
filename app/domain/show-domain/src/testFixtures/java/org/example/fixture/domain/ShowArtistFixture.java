package org.example.fixture.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.entity.show.ShowArtist;

public class ShowArtistFixture {

    public static List<ShowArtist> showArtists(List<UUID> showIds, List<UUID> artistIds, int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> ShowArtist.builder()
                .showId(showIds.get(i))
                .artistId(artistIds.get(i))
                .build()
            )
            .toList();
    }

}
