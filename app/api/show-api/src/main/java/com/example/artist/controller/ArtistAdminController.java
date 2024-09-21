package com.example.artist.controller;

import com.example.artist.controller.dto.response.ArtistDetailApiFormResponse;
import com.example.artist.service.ArtistAdminService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/artists")
public class ArtistAdminController {

    private final ArtistAdminService artistAdminService;


    @GetMapping("/list")
    public String findAllArtist(Model model) {
        List<ArtistDetailApiFormResponse> artistDetailApiFormResponses = artistAdminService.findAllWithGenreNames()
            .stream()
            .map(ArtistDetailApiFormResponse::new)
            .toList();

        model.addAttribute("artists", artistDetailApiFormResponses);
        return "artist_list_form";
    }
}