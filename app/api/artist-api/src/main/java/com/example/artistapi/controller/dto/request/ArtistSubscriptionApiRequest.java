package com.example.artistapi.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

public record ArtistSubscriptionApiRequest(
    @NotEmpty(message = "아티스트 ID는 최소 하나 이상 입력해야합니다.")
    List<UUID> artistIds
) {

}
