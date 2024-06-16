package com.example.show.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.pagination.vo.SortDirection;

public record ShowInterestPaginationApiRequest(

    @Schema(description = "정렬 방향")
    SortDirection sortDirection
) {

}
