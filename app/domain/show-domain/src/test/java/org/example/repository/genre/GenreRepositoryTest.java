package org.example.repository.genre;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.example.QueryTest;
import org.example.entity.genre.Genre;
import org.example.fixture.GenreFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class GenreRepositoryTest extends QueryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("findAllInIds 메서드가 의도대로 동작하는지 확인한다.")
    void find_all_in() {
        var genres = genreRepository.saveAll(
            GenreFixture.genres(2)
        );

        ArrayList<UUID> ids = new ArrayList<>(genres.stream().map(Genre::getId).toList());
        ids.add(UUID.randomUUID());

        List<Genre> findGenres = Assertions.assertDoesNotThrow(
            () -> genreRepository.findAllInId(ids)
        );

        assertThat(findGenres).hasSize(2);
    }

    @Test
    @DisplayName("findAllInIds 메서드가 매칭되는 ID가 없을 때 빈 리스트를 반환한다.")
    void find_all_in_no_match() {

        ArrayList<UUID> ids = new ArrayList<>();
        ids.add(UUID.randomUUID());

        List<Genre> findGenres = Assertions.assertDoesNotThrow(
            () -> genreRepository.findAllInId(ids)
        );

        assertThat(findGenres).hasSize(0);
    }
}