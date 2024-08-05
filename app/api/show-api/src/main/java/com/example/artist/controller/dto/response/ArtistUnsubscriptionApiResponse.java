package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistUnsubscriptionServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public record ArtistUnsubscriptionApiResponse(
    @Schema(description = "구독 취소한 아티스트 ID")
    List<UUID> successUnsubscriptionArtistIds
) {

    public static ArtistUnsubscriptionApiResponse from(
        ArtistUnsubscriptionServiceResponse response
    ) {
        return new ArtistUnsubscriptionApiResponse(response.successUnsubscriptionArtistIds());
    }
}
