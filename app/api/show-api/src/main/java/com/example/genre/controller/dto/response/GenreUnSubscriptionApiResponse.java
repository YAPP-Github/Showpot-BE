package com.example.genre.controller.dto.response;

import com.example.genre.service.dto.response.GenreUnSubscriptionServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public record GenreUnSubscriptionApiResponse(

    @Schema(description = "구독 취소한 장르 ID")
    List<UUID> successUnSubscriptionGenreIds
) {
    public static GenreUnSubscriptionApiResponse from(GenreUnSubscriptionServiceResponse response) {
        return new GenreUnSubscriptionApiResponse(response.successUnSubscriptionGenreIds());
    }
}
