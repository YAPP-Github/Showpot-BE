package com.example.artist.vo;

import org.example.vo.ArtistGender;

public enum ArtistGenderApiType {
    MAN, WOMAN;

    public ArtistGender toDomainType() {
        return switch (this) {
            case MAN -> ArtistGender.MAN;
            case WOMAN -> ArtistGender.WOMAN;
        };
    }
}
