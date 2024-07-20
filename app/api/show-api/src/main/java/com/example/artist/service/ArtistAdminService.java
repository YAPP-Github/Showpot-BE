package com.example.artist.service;

import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import com.example.artist.service.dto.request.ArtistUpdateServiceRequest;
import com.example.artist.service.dto.response.ArtistDetailServiceResponse;
import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.component.FileUploadComponent;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.entity.artist.Artist;
import org.example.usecase.artist.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistAdminService {

    private final ArtistUseCase artistUseCase;
    private final FileUploadComponent fileUploadComponent;

    public void save(ArtistCreateServiceRequest artistCreateServiceRequest) {
        String imageUrl = fileUploadComponent.uploadFile("artist", artistCreateServiceRequest.image());

        Artist artist = artistCreateServiceRequest.toArtistWithImageUrl(imageUrl);
        artistUseCase.save(artist, artistCreateServiceRequest.genreIds());
    }

    public List<ArtistDetailServiceResponse> findAllWithGenreNames() {
        List<ArtistDetailResponse> artistDetailResponses = artistUseCase.findAllWithGenreNames();
        return artistDetailResponses.stream()
            .map(ArtistDetailServiceResponse::new)
            .toList();
    }

    public List<ArtistKoreanNameServiceResponse> findAllArtistKoreanName() {
        List<ArtistKoreanNameResponse> artistKoreanNameResponses = artistUseCase.findAllArtistKoreanName();
        return artistKoreanNameResponses.stream()
            .map(ArtistKoreanNameServiceResponse::new)
            .toList();
    }

    public ArtistDetailServiceResponse findArtistById(UUID id) {
        return new ArtistDetailServiceResponse(artistUseCase.findArtistDetailById(id));
    }

    public void updateArtist(UUID id, ArtistUpdateServiceRequest artistUpdateServiceRequest) {
        String imageUrl = fileUploadComponent.uploadFile("artist", artistUpdateServiceRequest.image());

        Artist artist = artistUpdateServiceRequest.toArtist(imageUrl);
        artistUseCase.updateArtist(id, artist, artistUpdateServiceRequest.genreIds());
    }

    public void deleteArtist(UUID id) {
        artistUseCase.deleteArtist(id);
    }
}
