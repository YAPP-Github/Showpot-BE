package org.example.dto.show.response;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.dto.genre.response.GenreNameResponse;
import org.example.entity.show.info.SeatPrices;
import org.example.entity.show.info.TicketingSites;

public record ShowInfoDomainResponse(
    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image,
    SeatPrices seatPrices,
    TicketingSites ticketingSites,
    Set<ArtistKoreanNameResponse> artistKoreanNameResponses,
    Set<GenreNameResponse> genreNameResponses
) {

}
