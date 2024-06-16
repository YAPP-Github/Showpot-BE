package com.example.artist.controller.dto.response;

import java.util.List;

public record ArtistsApiResponse(
    List<ArtistSimpleApiResponse> artists,
    boolean hasNext
) {

}
