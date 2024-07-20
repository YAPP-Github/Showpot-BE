package com.example.artist.controller;

import com.example.artist.controller.dto.request.ArtistCreateApiForm;
import com.example.artist.controller.dto.request.ArtistUpdateApiForm;
import com.example.artist.controller.dto.response.ArtistDetailApiFormResponse;
import com.example.artist.service.ArtistAdminService;
import com.example.artist.service.dto.response.ArtistDetailServiceResponse;
import com.example.genre.controller.dto.response.GenreNameApiFormResponse;
import com.example.genre.service.GenreAdminService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/artists")
public class ArtistAdminController {

    private final ArtistAdminService artistAdminService;
    private final GenreAdminService genreAdminService;

    @GetMapping
    public String createArtist(Model model) {
        List<GenreNameApiFormResponse> genres = genreAdminService.findAllGenres().stream()
            .map(GenreNameApiFormResponse::new)
            .toList();
        model.addAttribute("genres", genres);
        return "artist_create_form";
    }

    @PostMapping
    public String createArtist(@Valid ArtistCreateApiForm artistCreateApiForm) {
        artistAdminService.save(artistCreateApiForm.toArtistCreateServiceRequest());
        return "redirect:/admin/artists/list";
    }

    @GetMapping("/list")
    public String findAllArtist(Model model) {
        List<ArtistDetailApiFormResponse> artistDetailApiFormResponses = artistAdminService.findAllWithGenreNames()
            .stream()
            .map(ArtistDetailApiFormResponse::new)
            .toList();

        model.addAttribute("artists", artistDetailApiFormResponses);
        return "artist_list_form";
    }

    @GetMapping("/{id}")
    public String findArtist(@PathVariable("id") UUID id, Model model) {
        List<GenreNameApiFormResponse> genres = genreAdminService.findAllGenres().stream()
            .map(GenreNameApiFormResponse::new)
            .toList();
        model.addAttribute("genres", genres);

        ArtistDetailServiceResponse artistDetailServiceResponse = artistAdminService.findArtistById(
            id);
        ArtistDetailApiFormResponse artistDetailApiFormResponse = new ArtistDetailApiFormResponse(
            artistDetailServiceResponse);
        model.addAttribute("artist", artistDetailApiFormResponse);

        return "artist_form";
    }

    @PutMapping("/{id}")
    public String updateArtist(
        @PathVariable("id") UUID id,
        @Valid ArtistUpdateApiForm artistUpdateApiForm
    ) {
        artistAdminService.updateArtist(id, artistUpdateApiForm.toArtistUpdateServiceRequest());
        return "redirect:/admin/artists/list";
    }

    @DeleteMapping("/{id}")
    public String deleteGenre(@PathVariable("id") UUID id) {
        artistAdminService.deleteArtist(id);
        return "redirect:/admin/artists/list";
    }

}