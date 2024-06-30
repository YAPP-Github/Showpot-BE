package com.example.artist.service;

import com.example.artist.service.dto.request.ArtistCreateServiceForm;
import lombok.RequiredArgsConstructor;
import org.example.entity.artist.Artist;
import org.example.usecase.artist.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistAdminService {

    private final ArtistUseCase artistUseCase;

    public void save(ArtistCreateServiceForm artistCreateServiceForm) {
        Artist artist = artistCreateServiceForm.toArtist();
        artistUseCase.save(artist, artistCreateServiceForm.genreIds());
    }

}
