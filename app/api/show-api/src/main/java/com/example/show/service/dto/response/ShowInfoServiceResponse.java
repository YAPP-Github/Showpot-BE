package com.example.show.service.dto.response;

import com.example.artist.service.dto.param.ArtistNameServiceParam;
import com.example.genre.service.dto.param.GenreNameServiceParam;
import com.example.show.service.dto.param.ShowTicketingTimeServiceParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.param.ArtistNamesWithShowIdDomainParam;
import org.example.dto.artist.response.ArtistNameDomainResponse;
import org.example.dto.genre.response.GenreNameDomainResponse;
import org.example.dto.genre.response.GenreNamesWithShowIdDomainParam;
import org.example.dto.show.param.ShowWithTicketingTimesDomainParam;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.dto.show.response.ShowTicketingTimeDomainResponse;

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
    List<ShowTicketingTimeServiceParam> ticketingSites,
    List<ArtistNameServiceParam> artistKoreanNameResponses,
    List<GenreNameServiceParam> genreNameResponses
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
        List<ShowWithTicketingTimesDomainParam> showWithTicketingTimes,
        List<ArtistNamesWithShowIdDomainParam> artistNamesWithShowId,
        List<GenreNamesWithShowIdDomainParam> genreNamesWithShowId
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
                        showWithTicketingTime.show().ticketingSites()
                    ),
                    showWithTicketingTime.ticketingTimes().stream()
                        .map(ShowTicketingTimeServiceParam::from)
                        .toList(),
                    artistKoreanNameResponses,
                    genreNameResponses
                );
            })
            .toList();
    }

    private static List<ShowTicketingTimeServiceParam> toShowTicketingTimeServiceResponses(
        Set<ShowTicketingTimeDomainResponse> ticketingSites
    ) {
        return ticketingSites.stream()
            .map(ShowTicketingTimeServiceParam::from)
            .toList();
    }

    private static List<ArtistNameServiceParam> toArtistKoreanNameServiceResponses(
        Set<ArtistNameDomainResponse> artistKoreanNameResponses) {
        return artistKoreanNameResponses
            .stream()
            .map(ArtistNameServiceParam::new)
            .toList();
    }

    private static List<GenreNameServiceParam> toGenreNameServiceResponses(
        Set<GenreNameDomainResponse> genreNameResponses) {
        return genreNameResponses
            .stream()
            .map(GenreNameServiceParam::new)
            .toList();
    }

    private static List<ArtistNameServiceParam> getArtistKoreanNameResponses(
        List<ArtistNamesWithShowIdDomainParam> artistNamesWithShowId,
        ShowWithTicketingTimesDomainParam showWitTicketingTimes
    ) {
        return artistNamesWithShowId.stream()
            .filter(
                artistResponse -> artistResponse.showId().equals(showWitTicketingTimes.show().id()))
            .flatMap(artistResponse -> artistResponse.koreanNameDomainResponses().stream())
            .map(ArtistNameServiceParam::new)
            .toList();
    }

    private static List<GenreNameServiceParam> getGenreNameResponses(
        List<GenreNamesWithShowIdDomainParam> genreNamesWithShowId,
        ShowWithTicketingTimesDomainParam showWithTicketingTimes
    ) {
        return genreNamesWithShowId.stream()
            .filter(
                genreResponse -> genreResponse.showId().equals(showWithTicketingTimes.show().id()))
            .flatMap(genreResponse -> genreResponse.genreNames().stream())
            .map(GenreNameServiceParam::new)
            .toList();
    }
}
