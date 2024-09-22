package org.example.port.dto.request;

import java.util.List;
import java.util.stream.IntStream;
import org.example.entity.artist.Artist;
import org.example.port.dto.param.ArtistSearchPortParam;

public record ArtistCreatePortRequest(
    List<ArtistDomainPortRequest> artists
) {

    public static ArtistCreatePortRequest from(
        List<ArtistSearchPortParam> params,
        List<Artist> newArtists
    ) {
        return new ArtistCreatePortRequest(
            IntStream.range(0, params.size())
                .mapToObj(i -> params.get(i).toDomainRequest(newArtists.get(i).getId()))
                .toList()
        );
    }

}
