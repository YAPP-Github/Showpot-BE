package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenreCreateServiceRequest;
import jakarta.validation.constraints.NotBlank;

public record GenreCreateApiForm(
    @NotBlank(message = "장르 이름은 필수 요청값 입니다.")
    String name
) {

    public GenreCreateServiceRequest toGenreCreateServiceRequest() {
        return new GenreCreateServiceRequest(name);

    }
}
