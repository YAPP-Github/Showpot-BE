package org.example.vo;

public enum ArtistFilterType {

    K_START("k-"), KOREAN("korean");

    private final String value;

    ArtistFilterType(String value) {
        this.value = value;
    }

    public static boolean isKoreanArtist(String genre) {
        return genre.contains(K_START.value) || genre.contains(KOREAN.value);
    }
}
