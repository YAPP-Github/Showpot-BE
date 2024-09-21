package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistSearchPaginationServiceRequest;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Max;
import java.util.UUID;

public record ArtistSearchPaginationApiRequest(

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null", example = "0")
    Integer cursorId,

    @Parameter(example = "30")
    @Max(value = 30, message = "조회하는 데이터의 최대 개수는 30입니다.")
    Integer size,

    @Parameter(description = "검색어", required = true)
    String search
) {

    public ArtistSearchPaginationApiRequest {

        if (cursorId == null) {
            cursorId = 0;
        }

        if (size == null) {
            size = 30;
        }
    }

    public ArtistSearchPaginationServiceRequest toServiceRequest(UUID userId) {
        return ArtistSearchPaginationServiceRequest.builder()
            .userId(userId)
            .cursor(cursorId)
            .size(size)
            .search(search)
            .build();
    }
}
