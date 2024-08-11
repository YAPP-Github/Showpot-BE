package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowInterestServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;

public record ShowInterestApiResponse(
    @Schema(description = "관심 여부 (T: 관심 있음, F: 관심 없음)")
    boolean hasInterest
) {

    public static ShowInterestApiResponse from(ShowInterestServiceResponse response) {
        return new ShowInterestApiResponse(response.hasInterest());
    }
}
