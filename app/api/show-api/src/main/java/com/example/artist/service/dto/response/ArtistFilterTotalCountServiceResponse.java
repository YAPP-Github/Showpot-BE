package com.example.artist.service.dto.response;

import org.example.dto.artist.response.ArtistFilterTotalCountDomainResponse;

public record ArtistFilterTotalCountServiceResponse(
    int totalCount
) {

    public static ArtistFilterTotalCountServiceResponse noneToTalCount() {
        return new ArtistFilterTotalCountServiceResponse(0);
    }

    public ArtistFilterTotalCountServiceResponse(ArtistFilterTotalCountDomainResponse response) {
        this(
            response.totalCount()
        );
    }

}
