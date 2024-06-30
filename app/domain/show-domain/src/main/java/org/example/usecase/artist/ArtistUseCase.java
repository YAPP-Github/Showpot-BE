package org.example.usecase.artist;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.artist.Artist;
import org.example.event.ArtistEvent;
import org.example.repository.artist.ArtistRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArtistUseCase {

    private final ArtistRepository artistRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void save(Artist artist, List<UUID> genreIds) {
        artistRepository.save(artist);
        eventPublisher.publishEvent(new ArtistEvent(this, artist, genreIds));
    }

}

