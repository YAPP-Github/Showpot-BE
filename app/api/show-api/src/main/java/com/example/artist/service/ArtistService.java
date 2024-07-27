package com.example.artist.service;

import com.example.artist.service.dto.param.ArtistSubscriptionPaginationServiceParam;
import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionServiceRequest;
import com.example.artist.service.dto.response.ArtistSubscriptionPaginationServiceResponse;
import com.example.artist.service.dto.response.ArtistSubscriptionServiceResponse;
import com.example.artist.service.dto.response.ArtistUnsubscriptionServiceResponse;
import java.util.List;
import java.util.UUID;
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
        List<Artist> existArtistsInRequest = artistUseCase.findAllArtistInIds(request.artistIds());
        List<UUID> existArtistIdsInRequest = existArtistsInRequest.stream()
            .map(Artist::getId)
            .toList();

        List<ArtistSubscription> subscriptions = artistSubscriptionUseCase.subscribe(
            existArtistIdsInRequest,
            request.userId()
        );

        return ArtistSubscriptionServiceResponse.builder()
            .successSubscriptionArtistIds(
                subscriptions.stream()
                    .map(ArtistSubscription::getArtistId)
                    .toList()
            ).build();
    }

    public ArtistUnsubscriptionServiceResponse unsubscribe(
        ArtistUnsubscriptionServiceRequest request
    ) {
        List<ArtistSubscription> unsubscribedArtists = artistSubscriptionUseCase.unsubscribe(
            request.artistIds(),
            request.userId()
        );

        return ArtistUnsubscriptionServiceResponse.builder()
            .successUnsubscriptionArtistIds(
                unsubscribedArtists.stream()
                    .map(ArtistSubscription::getArtistId)
                    .toList()
            ).build();
    }

    public ArtistSubscriptionPaginationServiceResponse findArtistSubscriptions(
        ArtistSubscriptionPaginationServiceRequest request
    ) {
        List<ArtistSubscription> subscriptions = artistSubscriptionUseCase.findSubscriptionList(request.userId());
        List<UUID> subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();

        if (subscriptionArtistIds.isEmpty()) {
            return ArtistSubscriptionPaginationServiceResponse.builder()
                .data(List.of())
                .hasNext(false)
                .build();
        }

        var response = artistUseCase.findAllArtistInCursorPagination(request.toDomainRequest(subscriptionArtistIds));
        List<ArtistSubscriptionPaginationServiceParam> data = response.data().stream()
            .map(ArtistSubscriptionPaginationServiceParam::new)
            .toList();

        return ArtistSubscriptionPaginationServiceResponse.builder()
            .data(data)
            .hasNext(response.hasNext())
            .build();
    }
}
