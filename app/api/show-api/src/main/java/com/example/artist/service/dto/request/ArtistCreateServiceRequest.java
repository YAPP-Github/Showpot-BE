package com.example.artist.service.dto.request;

import java.util.List;
import org.example.dto.artist.request.ArtistCreateDomainRequest;

public record ArtistCreateServiceRequest(
    List<ArtistGenreServiceRequest> artistGenres
) {

    public ArtistCreateDomainRequest toDomainRequest() {
        return new ArtistCreateDomainRequest(
            artistGenres.stream().map(ArtistGenreServiceRequest::toDomainRequest).toList()
        );
    }
}
