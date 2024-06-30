package org.example.listner;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistGenre;
import org.example.event.ArtistEvent;
import org.example.usecase.artist.ArtistGenreUseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistEventListener {

    private final ArtistGenreUseCase artistGenreUseCase;

    @EventListener
    public void handleArtistSavedEvent(ArtistEvent artistEvent) {
        Artist artist = artistEvent.getArtist();
        List<UUID> genreIds = artistEvent.getGenreIds();
        List<ArtistGenre> artistGenres = artist.toArtistGenre(genreIds);
        artistGenreUseCase.saveAll(artistGenres);
    }

}
