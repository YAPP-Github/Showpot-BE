package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistSubscriptionServiceRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

public record ArtistSubscriptionApiRequest(
    @Schema(description = "아티스트 ID 목록")
    @NotEmpty(message = "아티스트 ID는 최소 하나 이상 입력해야합니다.")
    List<UUID> artistIds
) {

    public ArtistSubscriptionServiceRequest toServiceRequest(UUID userId) {
        return new ArtistSubscriptionServiceRequest(artistIds, userId);
    }
}
