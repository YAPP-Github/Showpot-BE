package com.example.genre.controller.dto.request;

import io.swagger.v3.oas.annotations.Parameter;
import java.util.UUID;
import org.example.pagination.vo.SortDirection;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
public record GenrePaginationApiRequestParam(

    @Parameter(description = "정렬")
    SortDirection sort,

    @Parameter(description = "이전 페이지네이션 마지막 데이터의 ID / 최초 조회라면 null")
    UUID cursor
) {

}
