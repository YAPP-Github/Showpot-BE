package com.example.artist.service.dto.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ArtistDomainServiceRequest(
    UUID id,
    String name,
    String image,
    String spotifyId,
    List<String> genres
) {

}
