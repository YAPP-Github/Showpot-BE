package com.example.show.service.dto.response;

import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;
import org.example.dto.genre.response.GenreNameDomainResponse;
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
}
