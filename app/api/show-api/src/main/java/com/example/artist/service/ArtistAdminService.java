package com.example.artist.service;

import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import com.example.artist.service.dto.response.ArtistDetailServiceResponse;
import com.example.artist.service.dto.response.ArtistNameServiceResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.usecase.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistAdminService {

    private final ArtistUseCase artistUseCase;

    public List<ArtistNameServiceResponse> findAllArtistName() {
        return artistUseCase.findAllArtistKoreanName().stream()
            .map(ArtistNameServiceResponse::new)
            .toList();
    }

    public List<ArtistDetailServiceResponse> findAllWithGenreNames() {
        return artistUseCase.findAllWithGenreNames().stream()
            .map(ArtistDetailServiceResponse::new)
            .toList();
    }

    public void saveArtist(ArtistCreateServiceRequest request) {

    }
}
