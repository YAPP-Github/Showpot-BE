package com.example.genre.controller;

import com.example.genre.controller.dto.request.GenreCreateApiForm;
import com.example.genre.controller.dto.response.GenreNameApiFormResponse;
import com.example.genre.service.GenreAdminService;
import com.example.genre.service.dto.response.GenreNameServiceFormResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/genres")
public class GenreAdminController {

    private final GenreAdminService genreAdminService;

    @GetMapping("/")
    public String createGenre() {
        return "genre_create_form";
    }

    @PostMapping("/")
    public String createGenre(@Valid GenreCreateApiForm genreCreateApiForm) {
        genreAdminService.save(genreCreateApiForm.toGenreCreateServiceForm());
        return "redirect:/api/v1/admin/genres/list";
    }

    @GetMapping("/list")
    public String listGenres(Model model) {
        List<GenreNameServiceFormResponse> genreNameServiceForms = genreAdminService.getAllGenres();
        List<GenreNameApiFormResponse> genreNameApiFormResponses = genreNameServiceForms.stream()
            .map(response -> new GenreNameApiFormResponse(response.name()))
            .toList();

        model.addAttribute("genres", genreNameApiFormResponses);
        return "genre_list_form";
    }

}
