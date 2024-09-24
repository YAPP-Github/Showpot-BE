package com.example.artist.service.dto.request;

import java.util.List;

public record ArtistCreateServiceRequest(
    List<ArtistDomainServiceRequest> artists
) {

}
