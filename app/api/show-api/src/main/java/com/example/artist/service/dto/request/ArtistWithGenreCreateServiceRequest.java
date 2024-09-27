package com.example.artist.service.dto.request;

import java.util.List;
import org.example.dto.artist.request.ArtistWithGenreCreateDomainRequest;

public record ArtistWithGenreCreateServiceRequest(
    List<ArtistGenreServiceRequest> artistGenres
) {

    public ArtistWithGenreCreateDomainRequest toDomainRequest() {
        return new ArtistWithGenreCreateDomainRequest(
            artistGenres.stream().map(ArtistGenreServiceRequest::toDomainRequest).toList()
        );
    }
}
