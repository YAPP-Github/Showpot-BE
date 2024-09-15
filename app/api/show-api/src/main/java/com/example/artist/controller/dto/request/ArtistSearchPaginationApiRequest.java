package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistSearchPaginationServiceRequest;
import com.example.artist.vo.ArtistSortApiType;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record ArtistSearchPaginationApiRequest(

    @Parameter(
        description = "정렬 기준, default: ENGLISH_NAME_ASC",
        schema = @Schema(implementation = ArtistSortApiType.class)
    )
    ArtistSortApiType sortStandard,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "검색어", required = true)
    String search
) {

    public ArtistSearchPaginationApiRequest {
        if (sortStandard == null) {
            sortStandard = ArtistSortApiType.ENGLISH_NAME_ASC;
        }
    }

    public ArtistSearchPaginationServiceRequest toServiceRequest(UUID userId, int size) {
        return ArtistSearchPaginationServiceRequest.builder()
            .userId(userId)
            .sortStandard(sortStandard)
            .cursor(cursorId)
            .size(size)
            .search(search)
            .build();
    }
}
