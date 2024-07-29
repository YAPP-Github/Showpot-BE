package org.example.dto.show.response;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;
import org.example.dto.genre.response.GenreNameDomainResponse;
import org.example.entity.show.info.SeatPrice;
import org.example.entity.show.info.Ticketing;

public record ShowInfoDomainResponse(
    UUID id,
    String title,
    String content,
    LocalDate date,
    String location,
    String image,
    SeatPrice seatPrice,
    Ticketing ticketing,
    Set<ArtistKoreanNameDomainResponse> artistKoreanNameResponses,
    Set<GenreNameDomainResponse> genreNameResponses
) {

}
