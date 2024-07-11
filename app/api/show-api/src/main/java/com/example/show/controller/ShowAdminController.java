package com.example.show.controller;

import com.example.artist.controller.dto.response.ArtistKoreanNameApiResponse;
import com.example.artist.service.ArtistAdminService;
import com.example.genre.controller.dto.response.GenreNameApiFormResponse;
import com.example.genre.service.GenreAdminService;
import com.example.show.controller.dto.request.ShowCreateApiForm;
import com.example.show.service.ShowAdminService;
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
@RequestMapping("/admin/shows")
public class ShowAdminController {

    private final ShowAdminService showAdminService;
    private final ArtistAdminService artistAdminService;
    private final GenreAdminService genreAdminService;

    @GetMapping
    public String createArtist(Model model) {
        List<ArtistKoreanNameApiResponse> artists = artistAdminService.findAllArtistKoreanName()
            .stream()
            .map(ArtistKoreanNameApiResponse::new)
            .toList();

        List<GenreNameApiFormResponse> genres = genreAdminService.findAllGenres()
            .stream()
            .map(GenreNameApiFormResponse::new)
            .toList();

        model.addAttribute("artists", artists);
        model.addAttribute("genres", genres);
        return "show_create_form";
    }

    @PostMapping
    public String createArtist(@Valid ShowCreateApiForm showCreateApiForm) {
        showAdminService.save(showCreateApiForm.toServiceRequest());
        return "redirect:/admin/shows/list";
    }

}
