package com.example.artist.service.dto.response;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.response.ArtistKoreanNamesWithShowIdDomainResponse;

@Builder
public record ArtistKoreanNameWithShowIdServiceResponse(
    UUID showId,
    List<ArtistKoreanNameServiceResponse> koreanNameServiceResponses
) {

    public static ArtistKoreanNameWithShowIdServiceResponse from(
        ArtistKoreanNamesWithShowIdDomainResponse domainResponse
    ) {
        var koreanNames = domainResponse.koreanNameDomainResponses()
            .stream()
            .map(ArtistKoreanNameServiceResponse::new)
            .toList();

        return ArtistKoreanNameWithShowIdServiceResponse.builder()
            .showId(domainResponse.showId())
            .koreanNameServiceResponses(koreanNames)
            .build();
    }
}
