package com.example.genre.controller.dto.response;

import com.example.genre.service.dto.response.GenreSubscriptionServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GenreSubscriptionApiResponse(

    @Schema(description = "구독 성공한 장르 ID")
    List<UUID> successSubscriptionGenreIds
) {
    public static GenreSubscriptionApiResponse from(GenreSubscriptionServiceResponse response) {
        return new GenreSubscriptionApiResponse(response.successSubscriptionGenreIds());
    }

}
