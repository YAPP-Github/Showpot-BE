package org.spotify.client.dto.response;

import java.util.List;
import java.util.Optional;
import org.example.port.dto.param.ArtistSearchPortParam;

public record SpotifyArtistItemSearchResponse(
    String id,
    String name,
    List<String> genres,
    List<SpotifyArtistImageSearchResponse> images
) {

    public ArtistSearchPortParam toPortParam() {
        String imageURL = "";
        Optional<SpotifyArtistImageSearchResponse> optImage = images.stream()
            .max((a, b) -> b.width() - a.width());

        if (optImage.isPresent()) {
            imageURL = optImage.get().url();
        }

        return ArtistSearchPortParam.builder()
            .id(id)
            .name(name)
            .genres(genres)
            .imageURL(imageURL)
            .build();
    }
}
