package com.example.genre.controller.dto.response;

import com.example.genre.service.dto.response.GenreUnsubscriptionServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public record GenreUnsubscriptionApiResponse(

    @Schema(description = "구독 취소한 장르 ID")
    List<UUID> successUnsubscriptionGenreIds
) {
    public static GenreUnsubscriptionApiResponse from(GenreUnsubscriptionServiceResponse response) {
        return new GenreUnsubscriptionApiResponse(response.successUnsubscriptionGenreIds());
    }
}
