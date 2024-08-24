package com.example.genre.service;

import com.example.genre.service.dto.request.GenreCreateServiceRequest;
import com.example.genre.service.dto.request.GenreUpdateServiceRequest;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.genre.Genre;
import org.example.usecase.genre.GenreUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreAdminService {

    private final GenreUseCase genreUseCase;

    public void save(GenreCreateServiceRequest genreCreateServiceRequest) {
        genreUseCase.save(genreCreateServiceRequest.toGenre());
    }

    public List<GenreNameServiceResponse> findAllGenres() {
        List<Genre> genres = genreUseCase.findAllGenres();
        return genres.stream()
            .map(genre -> new GenreNameServiceResponse(genre.getId(), genre.getName()))
            .toList();
    }

    public void updateGenre(UUID id, GenreUpdateServiceRequest genreUpdateServiceRequest) {
        genreUseCase.updateGenre(id, genreUpdateServiceRequest.name());
    }

    public void deleteGenre(UUID id) {
        genreUseCase.deleteGenre(id);
    }

    public GenreNameServiceResponse findGenreById(UUID id) {
        Genre genre = genreUseCase.findGenreById(id);

        return new GenreNameServiceResponse(genre.getId(), genre.getName());
    }
}
