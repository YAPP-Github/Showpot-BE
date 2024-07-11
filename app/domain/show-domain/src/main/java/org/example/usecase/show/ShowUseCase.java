package org.example.usecase.show;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.show.Show;
import org.example.entity.show.ShowArtist;
import org.example.entity.show.ShowGenre;
import org.example.repository.show.ShowArtistRepository;
import org.example.repository.show.ShowGenreRepository;
import org.example.repository.show.ShowRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ShowUseCase {

    private final ShowRepository showRepository;
    private final ShowArtistRepository showArtistRepository;
    private final ShowGenreRepository showGenreRepository;

    @Transactional
    public void save(Show show, List<UUID> artistIds, List<UUID> genreIds) {
        showRepository.save(show);

        List<ShowArtist> showArtists = show.toShowArtist(artistIds);
        showArtistRepository.saveAll(showArtists);

        List<ShowGenre> showGenres = show.toShowGenre(genreIds);
        showGenreRepository.saveAll(showGenres);
    }

}
