package org.example.repository.artist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.example.QueryTest;
import org.example.dto.artist.request.ArtistFilterDomain;
import org.example.entity.artist.Artist;
import org.example.fixture.domain.ArtistFixture;
import org.example.fixture.domain.ArtistGenreFixture;
import org.example.fixture.domain.GenreFixture;
import org.example.fixture.dto.ArtistRequestDtoFixture;
import org.example.repository.artist.artistgenre.ArtistGenreRepository;
import org.example.repository.genre.GenreRepository;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistSortType;
import org.example.vo.ArtistType;
import org.example.vo.SubscriptionStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class ArtistRepositoryTest extends QueryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistGenreRepository artistGenreRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("findAllInIds 메서드가 의도대로 동작하는지 확인한다.")
    void find_all_in() {
        var artists = artistRepository.saveAll(
            List.of(
                ArtistFixture.womanGroup(),
                ArtistFixture.womanGroup()
            )
        );

        ArrayList<UUID> ids = new ArrayList<>(artists.stream().map(Artist::getId).toList());
        ids.add(UUID.randomUUID());

        List<Artist> findArtists = Assertions.assertDoesNotThrow(
            () -> artistRepository.findAllInIds(ids)
        );

        assertThat(findArtists).hasSize(2);
    }

    @Test
    @DisplayName("findAllInIds 메서드가 매칭되는 ID가 없을 때 빈 리스트를 반환한다.")
    void find_all_in_no_match() {

        ArrayList<UUID> ids = new ArrayList<>();
        ids.add(UUID.randomUUID());

        List<Artist> findArtists = Assertions.assertDoesNotThrow(
            () -> artistRepository.findAllInIds(ids)
        );

        assertThat(findArtists).hasSize(0);
    }

    @Test
    @DisplayName("구독한 아티스트 중 ID가 존재하는 아티스트 목록을 반환한다.")
    void findArtistSubscriptionExistArtistIds() {
        //given
        int artistSize = 3;
        var artists = ArtistFixture.manSoloArtists(artistSize);
        artistRepository.saveAll(artists);

        int size = 5;
        var request = ArtistRequestDtoFixture.artistPaginationDomainRequest(
            SubscriptionStatus.SUBSCRIBED,
            size,
            ArtistSortType.ENGLISH_NAME_ASC,
            null,
            artists.stream().map(Artist::getId).toList(),
            ArtistFilterDomain.defaultArtistFilterDomain()
        );

        //when
        var result = artistRepository.findAllWithCursorPagination(request);

        //then
        assertThat(result.data().size()).isEqualTo(artistSize);
    }

    @Test
    @DisplayName("구독한 아티스트 ID를 제외하고 구독하지 않은 아티스트 목록을 반환한다.")
    void findArtistUnsubscriptionExceptSubscribedArtistIds() {
        //given
        int artistSize = 3;
        var artists = ArtistFixture.manSoloArtists(artistSize);
        artistRepository.saveAll(artists);

        int size = 5;
        var request = ArtistRequestDtoFixture.artistPaginationDomainRequest(
            SubscriptionStatus.UNSUBSCRIBED,
            size,
            ArtistSortType.ENGLISH_NAME_ASC,
            null,
            artists.stream().map(Artist::getId).toList(),
            ArtistFilterDomain.defaultArtistFilterDomain()
        );

        //when
        var result = artistRepository.findAllWithCursorPagination(request);

        //then
        assertThat(result.data()).isEmpty();
    }

    @Test
    @DisplayName("구독한 아티스트가 없다면 저장되어 있는 아티스트 목록을 반환한다.")
    void findArtistUnsubscriptionWithNoneSubscriptionArtistIds() {
        //given
        int artistSize = 3;
        var artists = ArtistFixture.manSoloArtists(artistSize);
        artistRepository.saveAll(artists);

        int size = 5;
        var request = ArtistRequestDtoFixture.artistPaginationDomainRequest(
            SubscriptionStatus.UNSUBSCRIBED,
            size,
            ArtistSortType.ENGLISH_NAME_ASC,
            null,
            List.of(),
            ArtistFilterDomain.defaultArtistFilterDomain()
        );

        //when
        var result = artistRepository.findAllWithCursorPagination(request);

        //then
        assertThat(result.data().size()).isEqualTo(artistSize);
    }

    @Test
    @DisplayName("구독한 아티스트가 없다면 필터링 후 구독하지 않은 아티스트 목록을 반환한다.")
    void findArtisNoneSubscribedArtistIdsWithFilter() {
        int artistSize = 3;
        var artists = ArtistFixture.manSoloArtists(artistSize);
        artistRepository.saveAll(artists);

        var genres = GenreFixture.genres(1);
        genreRepository.saveAll(genres);

        artists.forEach(
            artist -> artistGenreRepository.save(
                ArtistGenreFixture.artistGenre(artist.getId(), genres.get(0).getId())
            )
        );

        int size = 5;
        var request = ArtistRequestDtoFixture.artistPaginationDomainRequest(
            SubscriptionStatus.UNSUBSCRIBED,
            size,
            ArtistSortType.ENGLISH_NAME_ASC,
            null,
            List.of(),
            ArtistFilterDomain.builder()
                .artistGenders(List.of(ArtistGender.MAN))
                .artistTypes(List.of(ArtistType.SOLO))
                .genreIds(List.of())
                .build()
        );

        //when
        var result = artistRepository.findAllWithCursorPagination(request);

        //then
        assertThat(result.data().size()).isEqualTo(artistSize);
    }

    @Test
    @DisplayName("구독한 아티스트 ID를 제외하고 구독하지 않은 아티스트 목록을 필터링한다.")
    void findArtistExceptSubscribedArtistIdsWithFilter() {
        int artistSize = 3;
        var artists = ArtistFixture.manSoloArtists(artistSize);
        artistRepository.saveAll(artists);

        var genres = GenreFixture.genres(1);
        genreRepository.saveAll(genres);

        artists.forEach(
            artist -> artistGenreRepository.save(
                ArtistGenreFixture.artistGenre(artist.getId(), genres.get(0).getId())
            )
        );

        int size = 5;
        var request = ArtistRequestDtoFixture.artistPaginationDomainRequest(
            SubscriptionStatus.UNSUBSCRIBED,
            size,
            ArtistSortType.ENGLISH_NAME_ASC,
            null,
            artists.stream().map(Artist::getId).toList(),
            ArtistFilterDomain.builder()
                .artistGenders(List.of(ArtistGender.MAN, ArtistGender.WOMAN))
                .artistTypes(List.of(ArtistType.SOLO, ArtistType.GROUP))
                .genreIds(List.of())
                .build()
        );

        //when
        var result = artistRepository.findAllWithCursorPagination(request);

        //then
        assertThat(result.data()).isEmpty();
    }

    @Test
    @DisplayName("구독한 아티스트가 없다면 필터링 후 구독하지 않은 아티스트 총 개수를 반환한다.")
    void findArtisTotalCountNoneSubscribedArtistIds() {
        int artistSize = 3;
        var artists = ArtistFixture.manSoloArtists(artistSize);
        artistRepository.saveAll(artists);

        var genres = GenreFixture.genres(1);
        genreRepository.saveAll(genres);

        artists.forEach(
            artist -> artistGenreRepository.save(
                ArtistGenreFixture.artistGenre(artist.getId(), genres.get(0).getId())
            )
        );

        var request = ArtistRequestDtoFixture.artistFilterTotalCountDomainRequest(
            List.of(ArtistGender.MAN, ArtistGender.WOMAN),
            List.of(ArtistType.SOLO, ArtistType.GROUP),
            List.of(),
            List.of()
        );

        //when
        var result = artistRepository.findFilterArtistTotalCount(request).orElseThrow();

        //then
        assertThat(result.totalCount()).isEqualTo(artistSize);
    }
}