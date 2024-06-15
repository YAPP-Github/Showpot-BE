package com.example.controller.show.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ShowInterestApiResponse(
    @Schema(description = "관심 여부 (T: 관심 있음, F: 관심 없음)")
    boolean hasInterest
) {

}
