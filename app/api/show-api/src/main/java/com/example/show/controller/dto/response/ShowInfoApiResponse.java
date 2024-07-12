package com.example.show.controller.dto.response;

import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import com.example.show.controller.vo.SeatPriceApiType;
import com.example.show.controller.vo.TicketingApiType;
import com.example.show.service.dto.response.ShowInfoServiceResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ShowInfoApiResponse(

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
    public ShowInfoApiResponse(ShowInfoServiceResponse showInfoServiceResponse) {
        this(
            showInfoServiceResponse.id(),
            showInfoServiceResponse.title(),
            showInfoServiceResponse.content(),
            showInfoServiceResponse.date(),
            showInfoServiceResponse.location(),
            showInfoServiceResponse.image(),
            showInfoServiceResponse.seatPriceApiType(),
            showInfoServiceResponse.ticketingApiType(),
            showInfoServiceResponse.artistKoreanNameResponses(),
            showInfoServiceResponse.genreNameResponses()
        );
    }

}
