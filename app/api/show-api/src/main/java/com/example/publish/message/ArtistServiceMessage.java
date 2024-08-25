package com.example.publish.message;

import java.util.UUID;
import lombok.Builder;
import org.example.entity.ArtistSubscription;
import org.example.entity.artist.Artist;

@Builder
public record ArtistServiceMessage(
    UUID id,
    String name
) {

    public static ArtistServiceMessage from(Artist artist) {
        return ArtistServiceMessage.builder()
            .id(artist.getId())
            .name(artist.getEnglishName())
            .build();
    }

    public static ArtistServiceMessage toUnsubscribe(ArtistSubscription artistSubscription) {
        return ArtistServiceMessage.builder()
            .id(artistSubscription.getArtistId())
            .name("empty")
            .build();
    }
}
