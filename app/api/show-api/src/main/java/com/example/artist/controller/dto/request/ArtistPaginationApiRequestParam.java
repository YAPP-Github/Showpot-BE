package com.example.artist.controller.dto.request;

import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;
import org.example.pagination.vo.SortDirection;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
public record ArtistPaginationApiRequestParam(

    @Parameter(
        description = "정렬",
        allowEmptyValue = true
    )
    SortDirection sort,

    @Parameter(
        description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null",
        allowEmptyValue = true
    )
    UUID cursor
) {

    public ArtistPaginationApiRequestParam {
        if (sort == null) {
            sort = SortDirection.DESC;
        }
    }
}
