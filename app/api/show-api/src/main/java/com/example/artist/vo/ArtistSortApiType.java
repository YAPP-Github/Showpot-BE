package com.example.artist.vo;

import org.example.vo.ArtistSortType;

public enum ArtistSortApiType {
    KOREAN_NAME_ASC,
    KOREAN_NAME_DESC,
    ENGLISH_NAME_ASC,
    ENGLISH_NAME_DESC;

    public ArtistSortType toDomainType() {
        return switch (this) {
            case KOREAN_NAME_ASC -> ArtistSortType.KOREAN_NAME_ASC;
            case KOREAN_NAME_DESC -> ArtistSortType.KOREAN_NAME_DESC;
            case ENGLISH_NAME_ASC -> ArtistSortType.ENGLISH_NAME_ASC;
            case ENGLISH_NAME_DESC -> ArtistSortType.ENGLISH_NAME_DESC;
        };
    }
}
