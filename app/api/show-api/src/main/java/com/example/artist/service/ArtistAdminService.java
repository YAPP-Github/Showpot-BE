package com.example.artist.service;

import com.example.artist.service.dto.param.ArtistNameServiceParam;
import com.example.artist.service.dto.request.ArtistWithGenreCreateServiceRequest;
import com.example.artist.service.dto.response.ArtistDetailServiceResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.usecase.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistAdminService {

    private final ArtistUseCase artistUseCase;

    public List<ArtistNameServiceParam> findAllArtistName() {
        return artistUseCase.findAllArtistName().stream()
            .map(ArtistNameServiceParam::new)
            .toList();
    }

    public List<ArtistDetailServiceResponse> findAllWithGenreNames() {
        return artistUseCase.findAllWithGenreNames().stream()
            .map(ArtistDetailServiceResponse::new)
            .toList();
    }

    public void saveArtist(ArtistWithGenreCreateServiceRequest request) {
        artistUseCase.save(request.toDomainRequest());
    }
}
