package org.example.dto.artist.response;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistDetailPaginationResponse(
    List<SimpleArtistResponse> data,
    boolean hasNext
) {

}
