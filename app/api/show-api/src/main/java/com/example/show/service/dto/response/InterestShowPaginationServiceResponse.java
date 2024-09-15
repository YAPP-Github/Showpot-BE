package com.example.show.service.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.show.Show;
import org.example.entity.usershow.InterestShow;

@Builder
public record InterestShowPaginationServiceResponse(
    UUID showId,
    UUID interestShowId,
    LocalDateTime interestedAt,
    String title,
    String location,
    String posterImageURL,
    LocalDate startAt,
    LocalDate endAt
) {

    public static InterestShowPaginationServiceResponse from(
        Show show,
        InterestShow interestShow
    ) {
        return InterestShowPaginationServiceResponse.builder()
            .showId(show.getId())
            .interestShowId(interestShow.getId())
            .interestedAt(interestShow.getUpdatedAt())
            .title(show.getTitle())
            .location(show.getLocation())
            .posterImageURL(show.getImage())
            .startAt(show.getStartDate())
            .endAt(show.getEndDate())
            .build();
    }
}
