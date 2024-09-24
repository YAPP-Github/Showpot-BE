package com.example.pub.message;

import java.util.UUID;
import lombok.Builder;
import org.example.entity.artist.Artist;
import org.example.entity.usershow.ArtistSubscription;

@Builder
public record ArtistServiceMessage(
    UUID id,
    String name
) {

    public static ArtistServiceMessage from(Artist artist) {
        return ArtistServiceMessage.builder()
            .id(artist.getId())
            .name(artist.getName())
            .build();
    }

    public static ArtistServiceMessage toUnsubscribe(ArtistSubscription artistSubscription) {
        return ArtistServiceMessage.builder()
            .id(artistSubscription.getArtistId())
            .name("empty")
            .build();
    }
}
