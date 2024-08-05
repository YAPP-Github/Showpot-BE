package org.example.repository.genre;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.example.QueryTest;
import org.example.entity.genre.Genre;
import org.example.fixture.domain.GenreFixture;
import org.example.fixture.dto.GenreRequestDtoFixture;
import org.example.vo.SubscriptionStatus;
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

    @Test
    @DisplayName("구독한 장르 중 ID가 존재하는 장르 목록을 반환한다.")
    void findGenreSubscriptionExistGenreIds() {
        //given
        int genreSize = 2;
        var genres = GenreFixture.genres(genreSize);
        genreRepository.saveAll(genres);

        var request = GenreRequestDtoFixture.genrePaginationDomainRequest(
            SubscriptionStatus.SUBSCRIBED,
            null,
            3,
            genres.stream().map(Genre::getId).toList()
        );

        //when
        var result = genreRepository.findAllWithCursorPagination(request);

        //then
        assertThat(result.data().size()).isEqualTo(genreSize);
    }

    @Test
    @DisplayName("구독한 장르가 없다면 저장되어 있는 장르 목록을 반환한다.")
    void findGenreUnsubscriptionWithNoneSubscriptionGenreIds() {
        //given
        int genreSize = 2;
        var genres = GenreFixture.genres(genreSize);
        genreRepository.saveAll(genres);

        var request = GenreRequestDtoFixture.genrePaginationDomainRequest(
            SubscriptionStatus.UNSUBSCRIBED,
            null,
            3,
            List.of()
        );

        //when
        var result = genreRepository.findAllWithCursorPagination(request);

        //then
        assertThat(result.data().size()).isEqualTo(genreSize);
    }

    @Test
    @DisplayName("구독한 장르가 있다면 제외하고 저장되어 있는 장르 목록을 반환한다.")
    void findGenreUnsubscriptionExceptSubscriptionGenreIds() {
        //given
        int genreSize = 3;
        var genres = GenreFixture.genres(genreSize);
        genreRepository.saveAll(genres);

        var genreSubscriptionIds = genres.stream().map(Genre::getId).toList();
        var request = GenreRequestDtoFixture.genrePaginationDomainRequest(
            SubscriptionStatus.UNSUBSCRIBED,
            null,
            3,
            genreSubscriptionIds
        );

        //when
        var result = genreRepository.findAllWithCursorPagination(request);

        //then
        assertThat(result.data()).isEmpty();
    }

}