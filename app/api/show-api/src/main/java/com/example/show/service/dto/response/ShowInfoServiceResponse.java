package com.example.show.service.dto.response;

import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;
import org.example.dto.artist.response.ArtistKoreanNamesWithShowIdDomainResponse;
import org.example.dto.genre.response.GenreNameDomainResponse;
import org.example.dto.genre.response.GenreNamesWithShowIdDomainResponse;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.dto.show.response.ShowTicketingTimeDomainResponse;
import org.example.dto.show.response.ShowWithTicketingTimesDomainResponse;

@Builder
public record ShowInfoServiceResponse(
    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image,
    ShowSeatServiceResponse seats,
    ShowTicketingSiteServiceResponse ticketingSiteInfos,
    List<ShowTicketingTimeServiceResponse> ticketingSites,
    List<ArtistKoreanNameServiceResponse> artistKoreanNameResponses,
    List<GenreNameServiceResponse> genreNameResponses
) {

    public ShowInfoServiceResponse(ShowInfoDomainResponse showInfo) {
        this(
            showInfo.show().id(),
            showInfo.show().title(),
            showInfo.show().content(),
            showInfo.show().startDate(),
            showInfo.show().endDate(),
            showInfo.show().location(),
            showInfo.show().image(),
            ShowSeatServiceResponse.from(showInfo.show().seatPrices()),
            ShowTicketingSiteServiceResponse.from(showInfo.show().ticketingSites()),
            toShowTicketingTimeServiceResponses(showInfo.ticketingTimes()),
            toArtistKoreanNameServiceResponses(showInfo.artistKoreanNameResponses()),
            toGenreNameServiceResponses(showInfo.genreNameResponses())
        );
    }

    public static List<ShowInfoServiceResponse> as(
        List<ShowWithTicketingTimesDomainResponse> showWithTicketingTimes,
        List<ArtistKoreanNamesWithShowIdDomainResponse> artistNamesWithShowId,
        List<GenreNamesWithShowIdDomainResponse> genreNamesWithShowId
    ) {
        return showWithTicketingTimes.stream()
            .map(showWithTicketingTime -> {
                var artistKoreanNameResponses = getArtistKoreanNameResponses(
                    artistNamesWithShowId,
                    showWithTicketingTime
                );
                var genreNameResponses = getGenreNameResponses(
                    genreNamesWithShowId,
                    showWithTicketingTime
                );

                return new ShowInfoServiceResponse(
                    showWithTicketingTime.show().id(),
                    showWithTicketingTime.show().title(),
                    showWithTicketingTime.show().content(),
                    showWithTicketingTime.show().startDate(),
                    showWithTicketingTime.show().endDate(),
                    showWithTicketingTime.show().location(),
                    showWithTicketingTime.show().image(),
                    ShowSeatServiceResponse.from(showWithTicketingTime.show().seatPrices()),
                    ShowTicketingSiteServiceResponse.from(
                        showWithTicketingTime.show().ticketingSites()),
                    showWithTicketingTime.ticketingTimes().stream()
                        .map(ShowTicketingTimeServiceResponse::from)
                        .toList(),
                    artistKoreanNameResponses,
                    genreNameResponses
                );
            })
            .toList();
    }

    private static List<ShowTicketingTimeServiceResponse> toShowTicketingTimeServiceResponses(
        Set<ShowTicketingTimeDomainResponse> ticketingSites
    ) {
        return ticketingSites.stream()
            .map(ShowTicketingTimeServiceResponse::from)
            .toList();
    }

    private static List<ArtistKoreanNameServiceResponse> toArtistKoreanNameServiceResponses(
        Set<ArtistKoreanNameDomainResponse> artistKoreanNameResponses) {
        return artistKoreanNameResponses
            .stream()
            .map(ArtistKoreanNameServiceResponse::new)
            .toList();
    }

    private static List<GenreNameServiceResponse> toGenreNameServiceResponses(
        Set<GenreNameDomainResponse> genreNameResponses) {
        return genreNameResponses
            .stream()
            .map(GenreNameServiceResponse::new)
            .toList();
    }

    private static List<ArtistKoreanNameServiceResponse> getArtistKoreanNameResponses(
        List<ArtistKoreanNamesWithShowIdDomainResponse> artistNamesWithShowId,
        ShowWithTicketingTimesDomainResponse showWitTicketingTimes
    ) {
        return artistNamesWithShowId.stream()
            .filter(
                artistResponse -> artistResponse.showId().equals(showWitTicketingTimes.show().id()))
            .flatMap(artistResponse -> artistResponse.koreanNameDomainResponses().stream())
            .map(ArtistKoreanNameServiceResponse::new)
            .toList();
    }

    private static List<GenreNameServiceResponse> getGenreNameResponses(
        List<GenreNamesWithShowIdDomainResponse> genreNamesWithShowId,
        ShowWithTicketingTimesDomainResponse showWithTicketingTimes
    ) {
        return genreNamesWithShowId.stream()
            .filter(
                genreResponse -> genreResponse.showId().equals(showWithTicketingTimes.show().id()))
            .flatMap(genreResponse -> genreResponse.genreNames().stream())
            .map(GenreNameServiceResponse::new)
            .toList();
    }
}
