package com.example.genre.service;

import com.example.genre.error.GenreError;
import com.example.genre.service.dto.request.GenreCreateServiceRequest;
import com.example.genre.service.dto.request.GenreUpdateServiceRequest;
import com.example.genre.service.dto.response.GenreNameServiceResponse;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.genre.Genre;
import org.example.exception.BusinessException;
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
        try {
            genreUseCase.updateGenre(id, genreUpdateServiceRequest.name());
        } catch (NoSuchElementException e) {
            throw new BusinessException(GenreError.ENTITY_NOT_FOUND);
        }
    }

    public void deleteGenre(UUID id) {
        try {
            genreUseCase.deleteGenre(id);
        } catch (NoSuchElementException e) {
            throw new BusinessException(GenreError.ENTITY_NOT_FOUND);
        }
    }

    public GenreNameServiceResponse findGenreById(UUID id) {
        Genre genre;
        try {
            genre = genreUseCase.findGenreById(id);
        } catch (NoSuchElementException e) {
            throw new BusinessException(GenreError.ENTITY_NOT_FOUND);
        }

        return new GenreNameServiceResponse(genre.getId(), genre.getName());
    }
}
