package org.example.fixture.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.entity.show.ShowGenre;

public class ShowGenreFixture {

    public static List<ShowGenre> showGenres(List<UUID> showIds, List<UUID> genreIds, int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> ShowGenre.builder()
                .showId(showIds.get(i))
                .genreId(genreIds.get(i))
                .build())
            .toList();
    }

    public static List<ShowGenre> showGenres(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> ShowGenre.builder()
                .showId(UUID.randomUUID())
                .genreId(UUID.randomUUID())
                .build()
            )
            .toList();
    }
}
