package com.example.show.service.dto.response;

import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import com.example.show.controller.dto.response.SeatInfoApiResponse;
import com.example.show.service.dto.param.ShowTicketingSiteServiceParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.dto.genre.response.GenreNameResponse;
import org.example.dto.show.response.ShowInfoDomainResponse;

@Builder
public record ShowInfoServiceResponse(
    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image,
    SeatInfoApiResponse seatInfoApiResponse,
    List<ShowTicketingSiteServiceParam> ticketingSiteInfos,
    List<ArtistKoreanNameServiceResponse> artistKoreanNameResponses,
    List<GenreNameServiceResponse> genreNameResponses
) {

    public ShowInfoServiceResponse(ShowInfoDomainResponse showInfo) {
        this(
            showInfo.id(),
            showInfo.title(),
            showInfo.content(),
            showInfo.startDate(),
            showInfo.endDate(),
            showInfo.location(),
            showInfo.image(),
            SeatInfoApiResponse.from(showInfo.seatPrices()),
            showInfo.ticketingSites().getSites()
                .stream()
                .map(siteName ->
                    ShowTicketingSiteServiceParam.builder()
                        .siteName(siteName)
                        .siteURL(showInfo.ticketingSites().getURLOrNullBy(siteName))
                        .build()
                ).toList(),
            toArtistKoreanNameServiceResponses(showInfo.artistKoreanNameResponses()),
            toGenreNameServiceResponses(showInfo.genreNameResponses())
        );
    }

    private static List<ArtistKoreanNameServiceResponse> toArtistKoreanNameServiceResponses(
        Set<ArtistKoreanNameResponse> artistKoreanNameResponses) {
        return artistKoreanNameResponses
            .stream()
            .map(ArtistKoreanNameServiceResponse::new)
            .toList();
    }

    private static List<GenreNameServiceResponse> toGenreNameServiceResponses(
        Set<GenreNameResponse> genreNameResponses) {
        return genreNameResponses
            .stream()
            .map(GenreNameServiceResponse::new)
            .toList();
    }
}
