package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistSubscriptionServiceResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;

public record ArtistSubscriptionApiResponse(

    @Schema(description = "구독 성공한 아티스트 ID")
    List<UUID> successSubscriptionArtistIds
) {

    public static ArtistSubscriptionApiResponse from(ArtistSubscriptionServiceResponse response) {
        return new ArtistSubscriptionApiResponse(response.successSubscriptionArtistIds());
    }
}
