package org.example.usecase.artist;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.entity.artist.ArtistGenre;
import org.example.repository.artist.ArtistGenreRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArtistGenreUseCase {

    private final ArtistGenreRepository artistGenreRepository;

    @Transactional
    public void saveAll(List<ArtistGenre> artistGenres) {
        artistGenreRepository.saveAll(artistGenres);
    }


}
