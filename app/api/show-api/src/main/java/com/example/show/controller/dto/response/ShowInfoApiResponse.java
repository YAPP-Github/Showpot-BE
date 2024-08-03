package com.example.show.controller.dto.response;

import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import com.example.show.controller.dto.param.ShowTicketingSiteApiParam;
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
    SeatInfoApiResponse seatInfoApiResponse,
    List<ShowTicketingSiteApiParam> showTicketingSiteApiParams,
    List<ArtistKoreanNameServiceResponse> artistKoreanNameResponses,
    List<GenreNameServiceResponse> genreNameResponses

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
            showInfoServiceResponse.seatInfoApiResponse(),
            showInfoServiceResponse.ticketingSiteInfos().stream()
                .map(ShowTicketingSiteApiParam::from)
                .toList(),
            showInfoServiceResponse.artistKoreanNameResponses(),
            showInfoServiceResponse.genreNameResponses()
        );
    }

}
