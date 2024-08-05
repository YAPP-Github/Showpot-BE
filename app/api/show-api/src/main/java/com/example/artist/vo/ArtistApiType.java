package com.example.artist.vo;

import org.example.vo.ArtistType;

public enum ArtistApiType {
    SOLO, GROUP;

    public ArtistType toDomainType() {
        return switch (this) {
            case SOLO -> ArtistType.SOLO;
            case GROUP -> ArtistType.GROUP;
        };
    }
}
