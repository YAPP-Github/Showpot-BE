package org.example.dto.artist.response;

import java.time.LocalDate;
import java.util.List;
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
    List<ArtistKoreanNameResponse> artistKoreanNameResponses,
    List<GenreNameResponse> genreNameResponses
) {

}
