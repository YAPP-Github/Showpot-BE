package com.example.show.service.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.InterestShow;
import org.example.entity.show.Show;

@Builder
public record InterestShowPaginationServiceResponse(
    UUID showId,
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
            .interestedAt(interestShow.getUpdatedAt())
            .title(show.getTitle())
            .location(show.getTitle())
            .posterImageURL(show.getImage())
            .startAt(show.getStartDate())
            .endAt(show.getEndDate())
            .build();
    }
}
