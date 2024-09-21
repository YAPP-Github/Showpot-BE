package com.example.show.service.dto.response;

import com.example.artist.service.dto.response.ArtistNameServiceResponse;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistNameDomainResponse;
import org.example.dto.artist.response.ArtistNamesWithShowIdDomainResponse;
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
    int viewCount,
    ShowSeatServiceResponse seats,
    ShowTicketingSiteServiceResponse ticketingSiteInfos,
    List<ShowTicketingTimeServiceResponse> ticketingSites,
    List<ArtistNameServiceResponse> artistKoreanNameResponses,
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
            showInfo.show().viewCount(),
            ShowSeatServiceResponse.from(showInfo.show().seatPrices()),
            ShowTicketingSiteServiceResponse.from(showInfo.show().ticketingSites()),
            toShowTicketingTimeServiceResponses(showInfo.ticketingTimes()),
            toArtistKoreanNameServiceResponses(showInfo.artistKoreanNameResponses()),
            toGenreNameServiceResponses(showInfo.genreNameResponses())
        );
    }

    public static List<ShowInfoServiceResponse> as(
        List<ShowWithTicketingTimesDomainResponse> showWithTicketingTimes,
        List<ArtistNamesWithShowIdDomainResponse> artistNamesWithShowId,
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
                    showWithTicketingTime.show().viewCount(),
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

    private static List<ArtistNameServiceResponse> toArtistKoreanNameServiceResponses(
        Set<ArtistNameDomainResponse> artistKoreanNameResponses) {
        return artistKoreanNameResponses
            .stream()
            .map(ArtistNameServiceResponse::new)
            .toList();
    }

    private static List<GenreNameServiceResponse> toGenreNameServiceResponses(
        Set<GenreNameDomainResponse> genreNameResponses) {
        return genreNameResponses
            .stream()
            .map(GenreNameServiceResponse::new)
            .toList();
    }

    private static List<ArtistNameServiceResponse> getArtistKoreanNameResponses(
        List<ArtistNamesWithShowIdDomainResponse> artistNamesWithShowId,
        ShowWithTicketingTimesDomainResponse showWitTicketingTimes
    ) {
        return artistNamesWithShowId.stream()
            .filter(
                artistResponse -> artistResponse.showId().equals(showWitTicketingTimes.show().id()))
            .flatMap(artistResponse -> artistResponse.koreanNameDomainResponses().stream())
            .map(ArtistNameServiceResponse::new)
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
