package com.example.show.controller.dto.response;

import com.example.artist.controller.dto.response.ArtistKoreanNameApiResponse;
import com.example.genre.controller.dto.response.GenreNameApiResponse;
import com.example.show.service.dto.response.ShowInfoServiceResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ShowInfoApiResponse(

    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image,
    ShowSeatApiResponse seatInfoApiResponse,
    ShowTicketingSiteApiResponse ticketingSiteApiResponse,
    List<ShowTicketingTimeApiResponse> ticketingTimes,
    List<ArtistKoreanNameApiResponse> artistKoreanNameResponses,
    List<GenreNameApiResponse> genreNameResponses
) {

    public ShowInfoApiResponse(ShowInfoServiceResponse showInfoServiceResponse) {
        this(
            showInfoServiceResponse.id(),
            showInfoServiceResponse.title(),
            showInfoServiceResponse.content(),
            showInfoServiceResponse.startDate(),
            showInfoServiceResponse.startDate(),
            showInfoServiceResponse.location(),
            showInfoServiceResponse.image(),
            ShowSeatApiResponse.from(showInfoServiceResponse.seats()),
            ShowTicketingSiteApiResponse.from(showInfoServiceResponse.ticketingSiteInfos()),
            showInfoServiceResponse.ticketingSites().stream()
                .map(ShowTicketingTimeApiResponse::from)
                .toList(),
            showInfoServiceResponse.artistKoreanNameResponses().stream()
                .map(ArtistKoreanNameApiResponse::new)
                .toList(),
            showInfoServiceResponse.genreNameResponses().stream()
                .map(GenreNameApiResponse::new)
                .toList()
        );
    }

    public static List<ShowInfoApiResponse> from(
        List<ShowInfoServiceResponse> showInfoServiceResponses
    ) {
        return showInfoServiceResponses.stream()
            .map(ShowInfoApiResponse::new)
            .toList();
    }
}
