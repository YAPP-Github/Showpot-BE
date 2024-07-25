package com.example.artist.vo;

import org.example.vo.ArtistSortStandardDomainType;

public enum ArtistSortStandardApiType {
    KOREAN_NAME_ASC,
    KOREAN_NAME_DESC,
    ENGLISH_NAME_ASC,
    ENGLISH_NAME_DESC;

    public ArtistSortStandardDomainType toDomainType() {
        return switch (this) {
            case KOREAN_NAME_ASC -> ArtistSortStandardDomainType.KOREAN_NAME_ASC;
            case KOREAN_NAME_DESC -> ArtistSortStandardDomainType.KOREAN_NAME_DESC;
            case ENGLISH_NAME_ASC -> ArtistSortStandardDomainType.ENGLISH_NAME_ASC;
            case ENGLISH_NAME_DESC -> ArtistSortStandardDomainType.ENGLISH_NAME_DESC;
        };
    }
}
