package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenreUnsubscriptionPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;

public record GenreUnsubscriptionPaginationApiRequest(
    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursor,

    @Parameter(description = "조회하는 데이터 개수")
    int size
) {

    public GenreUnsubscriptionPaginationServiceRequest toServiceRequest(UUID userId) {
        return GenreUnsubscriptionPaginationServiceRequest.builder()
            .cursor(cursor)
            .size(size)
            .userId(userId)
            .build();
    }
}
