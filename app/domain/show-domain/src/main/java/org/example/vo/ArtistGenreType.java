package org.example.vo;

import java.util.Arrays;
import java.util.List;

public enum ArtistGenreType {

    ROCK(
        List.of("rock", "alt-rock", "alternative", "british", "garage", "grunge", "hard-rock",
            "punk", "punk-rock", "rock-n-roll", "rockabilly", "psych-rock")
    ),
    BAND(
        List.of("band", "bluegrass", "blues", "folk", "guitar", "indie", "indie-pop",
            "singer-songwriter", "songwriter")
    ),
    EDM(
        List.of("breakbeat", "club", "dance", "edm", "electro", "electronic", "idm",
            "progressive-house", "trance")
    ),
    CLASSIC(List.of("classical", "new-age", "piano")),
    HIPHOP(List.of("hip-hop", "emo")),
    HOUSE(
        List.of("chicago-house", "deep-house", "detroit-techno", "disco", "house", "minimal-techno",
            "techno")
    ),
    OPERA(List.of("opera")),
    POP(
        List.of("acoustic", "anime", "cantopop", "disney", "pop", "power-pop", "swedish", "synth-pop")
    ),
    RNB(List.of("funk", "groove", "r-n-b", "soul")),
    MUSICAL(List.of("comedy", "movies", "pop-film", "show-tunes", "soundtracks")),
    METAL(
        List.of("black-metal", "death-metal", "grindcore", "hardcore", "heavy-metal", "metal",
        "metal-misc", "metalcore")
    ),
    JPOP(List.of("j-dance", "j-idol", "j-pop", "j-rock"));

    private final List<String> genres;

    ArtistGenreType(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getGenres() {
        return genres;
    }

    public static String findByGenreClassificationName(String genre) {
        return Arrays.stream(ArtistGenreType.values())
            .filter(type -> type.genres.contains(genre))
            .map(Enum::name)
            .findFirst()
            .orElse(null);
    }

}
