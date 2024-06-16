package com.example.show.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public record ShowAlertPaginationApiResponse(

    @Schema(description = "공연 목록")
    List<ShowSimpleApiResponse> shows,

    @Schema(description = "다음 페이지 존재 여부")
    boolean hasNext
) {

}
