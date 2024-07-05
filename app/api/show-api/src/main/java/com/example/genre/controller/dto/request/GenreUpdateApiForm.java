package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenreUpdateServiceRequest;
import jakarta.validation.constraints.NotBlank;

public record GenreUpdateApiForm(
    @NotBlank(message = "장르 이름은 필수 요청값 입니다.")
    String name
) {

    public GenreUpdateServiceRequest toGenreUpdateServiceRequest() {
        return new GenreUpdateServiceRequest(name);

    }
}