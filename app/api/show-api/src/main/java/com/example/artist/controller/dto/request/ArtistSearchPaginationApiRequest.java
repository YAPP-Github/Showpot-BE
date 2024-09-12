package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistSearchPaginationServiceRequest;
import com.example.artist.vo.ArtistSortApiType;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.UUID;
import org.example.security.dto.AuthenticatedUser;

public record ArtistSearchPaginationApiRequest(

    @Parameter(
        description = "정렬 기준, default: ENGLISH_NAME_ASC",
        schema = @Schema(implementation = ArtistSortApiType.class)
    )
    ArtistSortApiType sortStandard,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 cursorId / 최초 조회라면 null")
    UUID cursorId,

    @Parameter(description = "조회하는 데이터 개수", required = true)
    @Min(value = 10, message = "조회하는 데이터 개수는 최소 10개 이어야 합니다.")
    @Max(value = 30, message = "조회하는 데이터 개수는 최대 30개 이어야 합니다.")
    int size,

    @Parameter(description = "검색어", required = true)
    String search
) {

    public ArtistSearchPaginationApiRequest {
        if (sortStandard == null) {
            sortStandard = ArtistSortApiType.ENGLISH_NAME_ASC;
        }
    }

    public ArtistSearchPaginationServiceRequest toServiceRequest(AuthenticatedUser user) {
        UUID userId = null;
        if (user != null) {
            userId = user.userId();
        }

        return ArtistSearchPaginationServiceRequest.builder()
            .userId(userId)
            .sortStandard(sortStandard)
            .cursor(cursorId)
            .size(size)
            .search(search)
            .build();
    }
}
