package com.example.show.controller.dto.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowArtistSimpleApiResponse(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

}
