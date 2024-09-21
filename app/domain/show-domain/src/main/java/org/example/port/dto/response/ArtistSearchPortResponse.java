package org.example.port.dto.response;

import java.util.List;
import lombok.Builder;
import org.example.port.dto.param.ArtistSearchPortParam;

@Builder
public record ArtistSearchPortResponse(
    List<ArtistSearchPortParam> artists,
    int limit,
    int offset,
    boolean hasNext
) {

    public List<String> getSpotifyArtistIds() {
        return artists.stream()
            .map(ArtistSearchPortParam::id)
            .toList();
    }
}
