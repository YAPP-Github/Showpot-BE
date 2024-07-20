package com.example.show.service.dto.response;

import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import com.example.show.controller.dto.response.SeatInfoApiResponse;
import com.example.show.controller.dto.response.TicketingInfoApiResponse;
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
    SeatInfoApiResponse seatInfoApiResponse,
    TicketingInfoApiResponse ticketingInfoApiResponse,
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
            SeatInfoApiResponse.from(showInfoResponse.seatPrice()),
            TicketingInfoApiResponse.from(showInfoResponse.ticketing()),
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
