package com.example.genre.service;

import com.example.genre.service.dto.param.GenreNameServiceParam;
import com.example.genre.service.dto.request.GenreCreateServiceRequest;
import com.example.genre.service.dto.request.GenreUpdateServiceRequest;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.genre.Genre;
import org.example.usecase.GenreUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreAdminService {

    private final GenreUseCase genreUseCase;

    public void save(GenreCreateServiceRequest genreCreateServiceRequest) {
        genreUseCase.save(genreCreateServiceRequest.toGenre());
    }

    public List<GenreNameServiceParam> findAllGenres() {
        List<Genre> genres = genreUseCase.findAllGenres();
        return genres.stream()
            .map(genre -> new GenreNameServiceParam(genre.getId(), genre.getName()))
            .toList();
    }

    public void updateGenre(UUID id, GenreUpdateServiceRequest genreUpdateServiceRequest) {
        genreUseCase.updateGenre(id, genreUpdateServiceRequest.name());
    }

    public void deleteGenre(UUID id) {
        genreUseCase.deleteGenre(id);
    }

    public GenreNameServiceParam findGenreById(UUID id) {
        Genre genre = genreUseCase.findGenreById(id);

        return new GenreNameServiceParam(genre.getId(), genre.getName());
    }
}
