package com.example.artist.controller;

import com.example.artist.controller.dto.request.ArtistCreateApiForm;
import com.example.artist.service.ArtistAdminService;
import com.example.genre.service.GenreAdminService;
import com.example.genre.service.dto.response.GenreNameServiceFormResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/artists")
public class ArtistAdminController {

    private final ArtistAdminService artistAdminService;
    private final GenreAdminService genreAdminService;

    @GetMapping
    public String createArtist(Model model) {
        List<GenreNameServiceFormResponse> genres = genreAdminService.findAllGenres();
        model.addAttribute("genres", genres);
        return "artist_create_form";
    }

    @PostMapping
    public String createArtist(@Valid @ModelAttribute ArtistCreateApiForm artistCreateApiForm) {
        artistAdminService.save(artistCreateApiForm.toArtistCreateServiceForm());
        return "redirect:/api/v1/admin/artist/list";
    }
}