package org.example.fixture;

import java.util.List;
import java.util.stream.IntStream;
import org.example.entity.genre.Genre;

public class GenreFixture {

    public static List<Genre> genres(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> Genre.builder()
                .name("test_genre" + i)
                .build())
            .toList();
    }
}
