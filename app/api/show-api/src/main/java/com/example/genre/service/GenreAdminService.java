package com.example.genre.service;

import com.example.genre.service.dto.request.GenreCreateServiceForm;
import com.example.genre.service.dto.response.GenreNameServiceFormResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.entity.genre.Genre;
import org.example.usecase.genre.GenreUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreAdminService {

    private final GenreUseCase genreUseCase;

    public void save(GenreCreateServiceForm genreCreateServiceForm) {
        genreUseCase.save(genreCreateServiceForm.toGenre());
    }


    public List<GenreNameServiceFormResponse> getAllGenres() {
        List<Genre> genres = genreUseCase.findAllGenres();
        return genres.stream()
            .map(genre -> new GenreNameServiceFormResponse(genre.getName()))
            .toList();
    }
}
