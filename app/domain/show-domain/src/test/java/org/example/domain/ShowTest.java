package org.example.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;
import org.example.entity.show.Show;
import org.example.entity.show.ShowArtist;
import org.example.entity.show.ShowGenre;
import org.example.fixture.domain.ShowFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShowTest {

    private final Show show = ShowFixture.deafultShow();

    @Test
    @DisplayName("아티스트 아이디들로 ShowArtist들을 생성할 수 있다.")
    void artistIdsToShowArtist() {
        // given
        List<UUID> artistIds = List.of(UUID.randomUUID(), UUID.randomUUID());

        // when
        List<ShowArtist> showArtists = show.toShowArtist(artistIds);

        // then
        assertThat(showArtists).allSatisfy(showArtist -> {
            assertThat(showArtist.getShowId()).isEqualTo(show.getId());
            assertThat(artistIds).contains(showArtist.getArtistId());
        });
    }

    @Test
    @DisplayName("장르 아이디들로 ShowGenre들을 생성할 수 있다.")
    void genreIdsToShowGenre() {
        // given
        List<UUID> genreIds = List.of(UUID.randomUUID(), UUID.randomUUID());

        // when
        List<ShowGenre> showGenres = show.toShowGenre(genreIds);

        // then
        assertThat(showGenres).allSatisfy(showGenre -> {
            assertThat(showGenre.getShowId()).isEqualTo(show.getId());
            assertThat(genreIds).contains(showGenre.getGenreId());
        });
    }

}
