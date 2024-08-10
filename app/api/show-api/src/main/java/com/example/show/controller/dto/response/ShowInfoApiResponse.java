package com.example.show.controller.dto.response;

import com.example.artist.controller.dto.response.ArtistKoreanNameApiResponse;
import com.example.artist.service.dto.response.ArtistKoreanNameWithShowIdServiceResponse;
import com.example.genre.controller.dto.response.GenreNameApiResponse;
import com.example.genre.service.dto.response.GenreNameWithShowIdServiceResponse;
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

    public static List<ShowInfoApiResponse> as(
        List<ShowWithTicketingTimesServiceResponse> showWithTicketingTimes,
        List<ArtistKoreanNameWithShowIdServiceResponse> artistNamesWithShowId,
        List<GenreNameWithShowIdServiceResponse> genreNamesWithShowId
    ) {
        return showWithTicketingTimes.stream()
            .map(show -> {
                var artistKoreanNameResponses = getArtistKoreanNameResponses(
                    artistNamesWithShowId,
                    show
                );
                var genreNameResponses = getGenreNameResponses(genreNamesWithShowId, show);

                return new ShowInfoApiResponse(
                    show.id(),
                    show.title(),
                    show.content(),
                    show.startDate(),
                    show.endDate(),
                    show.location(),
                    show.image(),
                    ShowSeatApiResponse.from(show.seats()),
                    ShowTicketingSiteApiResponse.from(show.ticketingSiteInfos()),
                    show.ticketingTimes().stream()
                        .map(ShowTicketingTimeApiResponse::from)
                        .toList(),
                    artistKoreanNameResponses,
                    genreNameResponses
                );
            })
            .toList();
    }

    private static List<ArtistKoreanNameApiResponse> getArtistKoreanNameResponses(
        List<ArtistKoreanNameWithShowIdServiceResponse> artistNamesWithShowId,
        ShowWithTicketingTimesServiceResponse show
    ) {
        return artistNamesWithShowId.stream()
            .filter(artistResponse -> artistResponse.showId().equals(show.id()))
            .flatMap(artistResponse -> artistResponse.koreanNameServiceResponses().stream())
            .map(ArtistKoreanNameApiResponse::new)
            .toList();
    }

    private static List<GenreNameApiResponse> getGenreNameResponses(
        List<GenreNameWithShowIdServiceResponse> genreNamesWithShowId,
        ShowWithTicketingTimesServiceResponse show
    ) {
        return genreNamesWithShowId.stream()
            .filter(genreResponse -> genreResponse.showId().equals(show.id()))
            .flatMap(genreResponse -> genreResponse.genreNames().stream())
            .map(GenreNameApiResponse::new)
            .toList();
    }

}
