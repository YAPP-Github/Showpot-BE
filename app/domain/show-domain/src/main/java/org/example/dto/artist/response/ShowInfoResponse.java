package org.example.dto.artist.response;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import org.example.entity.show.info.SeatPrice;
import org.example.entity.show.info.Ticketing;

public record ShowInfoResponse(
    UUID id,
    String title,
    String content,
    LocalDate date,
    String location,
    String image,
    SeatPrice seatPrice,
    Ticketing ticketing,
    Set<ArtistKoreanNameResponse> artistKoreanNameResponses,
    Set<GenreNameResponse> genreNameResponses
) {

}
