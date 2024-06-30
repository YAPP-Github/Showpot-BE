package org.example.event;

import java.util.List;
import java.util.UUID;
import lombok.Getter;
import org.example.entity.artist.Artist;
import org.springframework.context.ApplicationEvent;

@Getter
public class ArtistEvent extends ApplicationEvent {

    private final Artist artist;
    private final List<UUID> genreIds;

    public ArtistEvent(Object source, Artist artist, List<UUID> genreIds) {
        super(source);
        this.artist = artist;
        this.genreIds = genreIds;
    }

}
