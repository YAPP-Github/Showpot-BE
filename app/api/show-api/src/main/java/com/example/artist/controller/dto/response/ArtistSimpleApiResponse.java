package com.example.artist.controller.dto.response;

import java.util.UUID;

public record ArtistSimpleApiResponse(
    UUID id,
    String name,
    String profileImage
) {

}
