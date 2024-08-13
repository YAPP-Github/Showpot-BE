package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.InterestShowPaginationServiceResponse;
import java.util.UUID;
import lombok.Builder;
import org.example.util.DateTimeUtil;

@Builder
public record InterestShowPaginationApiResponse(
    UUID id,
    String title,
    String startAt,
    String endAt,
    String location,
    String posterImageURL,
    String interestedAt
) {

    public static InterestShowPaginationApiResponse from(InterestShowPaginationServiceResponse response) {
        return InterestShowPaginationApiResponse.builder()
            .id(response.showId())
            .title(response.title())
            .startAt(DateTimeUtil.formatDate(response.startAt()))
            .endAt(DateTimeUtil.formatDate(response.endAt()))
            .location(response.location())
            .posterImageURL(response.posterImageURL())
            .interestedAt(DateTimeUtil.formatDateTime(response.interestedAt()))
            .build();
    }
}
