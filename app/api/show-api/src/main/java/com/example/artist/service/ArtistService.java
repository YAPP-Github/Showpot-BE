package com.example.artist.service;

import com.example.artist.service.dto.request.ArtistSubscriptionServiceRequest;
import com.example.artist.service.dto.response.ArtistSubscriptionServiceResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.ArtistSubscription;
import org.example.entity.artist.Artist;
import org.example.usecase.ArtistSubscriptionUseCase;
import org.example.usecase.artist.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArtistService {

    private final ArtistUseCase artistUseCase;
    private final ArtistSubscriptionUseCase artistSubscriptionUseCase;

    public ArtistSubscriptionServiceResponse subscribe(ArtistSubscriptionServiceRequest request) {
        List<Artist> existArtists = artistUseCase.findAllArtistInIds(request.artistIds());

        List<ArtistSubscription> newArtistSubscription = getNewArtistSubscription(
            existArtists,
            request.userId()
        );

        artistSubscriptionUseCase.subscribe(newArtistSubscription);

        return ArtistSubscriptionServiceResponse.builder()
            .successSubscriptionArtistIds(
                newArtistSubscription.stream()
                    .map(ArtistSubscription::getArtistId)
                    .toList()
            )
            .build();
    }

    private List<ArtistSubscription> getNewArtistSubscription(
        List<Artist> artists,
        UUID userId
    ) {
        var existSubscriptionByArtistId = getExistSubscriptionByArtistId(userId);
        return artists.stream()
            .filter(artist -> !existSubscriptionByArtistId.containsKey(artist.getId()))
            .map(artist ->
                ArtistSubscription.builder()
                    .artistId(artist.getId())
                    .userId(userId)
                    .build()
            ).toList();
    }

    private Map<UUID, ArtistSubscription> getExistSubscriptionByArtistId(UUID userId) {
        return artistSubscriptionUseCase.findSubscriptionList(userId)
            .stream()
            .collect(
                Collectors.toMap(
                    ArtistSubscription::getArtistId,
                    artistSubscription -> artistSubscription
                )
            );
    }
}
