package com.example.artist.service;

import com.example.artist.service.dto.response.ArtistSearchServiceResponse;
import lombok.RequiredArgsConstructor;
import org.example.usecase.artist.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistUseCase artistUseCase;

    public ArtistSearchServiceResponse searchArtist(String name) {
        return new ArtistSearchServiceResponse(artistUseCase.searchArtist(name));
    }


}
