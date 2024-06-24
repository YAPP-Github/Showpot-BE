package org.example.usecase.genre;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.entity.genre.Genre;
import org.example.repository.genre.GenreRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class GenreUseCase {

    private final GenreRepository genreRepository;

    @Transactional
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    @Transactional(readOnly = true)
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

}
