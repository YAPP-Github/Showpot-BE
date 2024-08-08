package org.example.repository.show;

import org.assertj.core.api.SoftAssertions;
import org.example.QueryTest;
import org.example.entity.genre.Genre;
import org.example.entity.show.Show;
import org.example.fixture.domain.GenreFixture;
import org.example.fixture.domain.ShowFixture;
import org.example.fixture.domain.ShowGenreFixture;
import org.example.repository.genre.GenreRepository;
import org.example.repository.show.showgenre.ShowGenreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowGenreRepositoryTest extends QueryTest {

    @Autowired
    private ShowGenreRepository showGenreRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("공연과 연관된 장르 이름을 함께 가져온다.")
    void findGenreNamesWithShowId() {
        //given
        var genres = GenreFixture.genres(2);
        genreRepository.saveAll(genres);

        var shows = ShowFixture.shows(2);
        showRepository.saveAll(shows);

        var showGenres = ShowGenreFixture.showGenre(
            shows.stream().map(Show::getId).toList(),
            genres.stream().map(Genre::getId).toList(),
            2
        );
        showGenreRepository.saveAll(showGenres);

        //when
        var result = showGenreRepository.findGenreNamesWithShowId();

        //then
        SoftAssertions.assertSoftly(
            soft -> {
                soft.assertThat(result.size()).isEqualTo(2);
                soft.assertThat(result.get(0).genreNames().size()).isEqualTo(1);
            }
        );
    }
}
