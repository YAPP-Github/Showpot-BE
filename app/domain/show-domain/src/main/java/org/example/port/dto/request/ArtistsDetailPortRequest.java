package org.example.port.dto.request;

import java.util.List;
import lombok.Builder;

@Builder
public record ArtistsDetailPortRequest(
    String accessToken,
    List<String> spotifyArtistIds
) {

}
