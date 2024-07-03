package com.example.artist.service;

import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import com.example.artist.service.dto.request.ArtistUpdateServiceRequest;
import com.example.artist.service.dto.response.ArtistDetailServiceResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.entity.artist.Artist;
import org.example.usecase.artist.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistAdminService {

    private final ArtistUseCase artistUseCase;

    public void save(ArtistCreateServiceRequest artistCreateServiceRequest) {
        Artist artist = artistCreateServiceRequest.toArtist();
        artistUseCase.save(artist, artistCreateServiceRequest.genreIds());
    }

    public List<ArtistDetailServiceResponse> findAllArtist() {
        List<ArtistDetailResponse> artistDetailResponses = artistUseCase.findAllWithGenreNames();
        return artistDetailResponses.stream()
            .map(ArtistDetailServiceResponse::new)
            .toList();
    }

    public ArtistDetailServiceResponse findArtistById(UUID id) {
        return new ArtistDetailServiceResponse(artistUseCase.findArtistDetailById(id));
    }

    public void updateArtist(UUID id, ArtistUpdateServiceRequest artistUpdateServiceRequest) {
        Artist artist = artistUpdateServiceRequest.toArtist();
        artistUseCase.updateArtist(id, artist, artistUpdateServiceRequest.genreIds());
    }

    public void deleteArtist(UUID id) {
        artistUseCase.deleteArtist(id);
    }
}
