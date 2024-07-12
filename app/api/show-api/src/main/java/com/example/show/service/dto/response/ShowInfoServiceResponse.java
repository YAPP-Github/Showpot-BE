package com.example.show.service.dto.response;

import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import com.example.show.controller.vo.SeatPriceApiType;
import com.example.show.controller.vo.TicketingApiType;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.dto.artist.response.GenreNameResponse;
import org.example.dto.artist.response.ShowInfoResponse;

public record ShowInfoServiceResponse(
    UUID id,
    String title,
    String content,
    LocalDate date,
    String location,
    String image,
    SeatPriceApiType seatPriceApiType,
    TicketingApiType ticketingApiType,
    List<ArtistKoreanNameServiceResponse> artistKoreanNameResponses,
    List<GenreNameServiceResponse> genreNameResponses
) {

    public ShowInfoServiceResponse(ShowInfoResponse showInfoResponse) {
        this(
            showInfoResponse.id(),
            showInfoResponse.title(),
            showInfoResponse.content(),
            showInfoResponse.date(),
            showInfoResponse.location(),
            showInfoResponse.image(),
            SeatPriceApiType.from(showInfoResponse.seatPrice()),
            TicketingApiType.from(showInfoResponse.ticketing()),
            toArtistKoreanNameServiceResponses(showInfoResponse.artistKoreanNameResponses()),
            toGenreNameServiceResponses(showInfoResponse.genreNameResponses())
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
