package com.example.artist.controller.dto.response;

import java.util.List;

public record ArtistPaginationApiResponse(
    List<ArtistSimpleApiResponse> artists,
    boolean hasNext
) {

}
