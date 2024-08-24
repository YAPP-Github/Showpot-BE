package com.example.artist.service;

import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import com.example.artist.service.dto.request.ArtistUpdateServiceRequest;
import com.example.artist.service.dto.response.ArtistDetailServiceResponse;
import com.example.artist.service.dto.response.ArtistKoreanNameServiceResponse;
import com.example.component.FileUploadComponent;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDetailDomainResponse;
import org.example.entity.artist.Artist;
import org.example.usecase.artist.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistAdminService {

    private final ArtistUseCase artistUseCase;
    private final FileUploadComponent fileUploadComponent;

    public void save(ArtistCreateServiceRequest artistCreateServiceRequest) {
        String imageUrl = fileUploadComponent.uploadFile("artists", artistCreateServiceRequest.image());
        Artist artist = artistCreateServiceRequest.toArtistWithImageUrl(imageUrl);

        artistUseCase.save(artist, artistCreateServiceRequest.genreIds());
    }

    public List<ArtistDetailServiceResponse> findAllWithGenreNames() {
        return artistUseCase.findAllWithGenreNames().stream()
            .map(ArtistDetailServiceResponse::new)
            .toList();
    }

    public List<ArtistKoreanNameServiceResponse> findAllArtistKoreanName() {
        return artistUseCase.findAllArtistKoreanName().stream()
            .map(ArtistKoreanNameServiceResponse::new)
            .toList();
    }

    public ArtistDetailServiceResponse findArtistById(UUID id) {
        ArtistDetailDomainResponse response;
        response = artistUseCase.findArtistDetailById(id);

        return new ArtistDetailServiceResponse(response);
    }

    public void updateArtist(UUID id, ArtistUpdateServiceRequest artistUpdateServiceRequest) {
        String imageUrl = fileUploadComponent.uploadFile("artist",
            artistUpdateServiceRequest.image());
        Artist artist = artistUpdateServiceRequest.toArtist(imageUrl);

        artistUseCase.updateArtist(id, artist, artistUpdateServiceRequest.genreIds());
    }

    public void deleteArtist(UUID id) {
        artistUseCase.deleteArtist(id);
    }
}
