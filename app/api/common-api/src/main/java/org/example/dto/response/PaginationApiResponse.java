package org.example.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

public record PaginationApiResponse<T>(
    @Schema(description = "조회한 데이터 개수")
    int size,
    @Schema(description = "다음 조회 가능 여부")
    boolean hasNext,
    @Schema(description = "조회 데이터")
    List<T> data
) {

    @Builder
    public PaginationApiResponse(
        List<T> data,
        boolean hasNext
    ) {
        this(data.size(), hasNext, data);
    }
}
