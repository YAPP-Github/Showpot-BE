package org.example.dto.show.response;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.dto.genre.response.GenreNameResponse;
import org.example.entity.show.info.SeatPrice;
import org.example.entity.show.info.Ticketing;

public record ShowInfoResponse(
    UUID id,
    String title,
    String content,
    LocalDate startDate,
    LocalDate endDate,
    String location,
    String image,
    SeatPrice seatPrice,
    Ticketing ticketing,
    Set<ArtistKoreanNameResponse> artistKoreanNameResponses,
    Set<GenreNameResponse> genreNameResponses
) {

}
