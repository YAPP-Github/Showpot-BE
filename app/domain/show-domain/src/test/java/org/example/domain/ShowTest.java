package org.example.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.example.entity.show.Show;
import org.example.entity.show.ShowArtist;
import org.example.entity.show.ShowGenre;
import org.example.entity.show.ShowTicketingTime;
import org.example.entity.show.info.ShowTicketingTimes;
import org.example.fixture.domain.ShowFixture;
import org.example.vo.TicketingType;
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
        assertThat(showArtists).allSatisfy(
            showArtist -> {
                assertThat(showArtist.getShowId()).isEqualTo(show.getId());
                assertThat(artistIds).contains(showArtist.getArtistId());
            }
        );
    }

    @Test
    @DisplayName("장르 아이디들로 ShowGenre들을 생성할 수 있다.")
    void genreIdsToShowGenre() {
        // given
        List<UUID> genreIds = List.of(UUID.randomUUID(), UUID.randomUUID());

        // when
        List<ShowGenre> showGenres = show.toShowGenre(genreIds);

        // then
        assertThat(showGenres).allSatisfy(
            showGenre -> {
                assertThat(showGenre.getShowId()).isEqualTo(show.getId());
                assertThat(genreIds).contains(showGenre.getGenreId());
            }
        );
    }

    @Test
    @DisplayName("공연 티켓팅 예매 시간을 List 타입으로 반환한다.")
    void showTicketingTimesToList() {
        //given
        ShowTicketingTimes showTicketingTimes = new ShowTicketingTimes();
        showTicketingTimes.saveTicketingTimes(TicketingType.PRE, LocalDateTime.now());
        showTicketingTimes.saveTicketingTimes(TicketingType.NORMAL, LocalDateTime.now());
        showTicketingTimes.saveTicketingTimes(TicketingType.ADDITIONAL, LocalDateTime.now());

        //when
        List<ShowTicketingTime> results = show.toShowTicketingTime(showTicketingTimes);

        //then
        assertThat(results.size()).isEqualTo(showTicketingTimes.getTicketingTimeByType().size());

    }

}
