package com.example.artist.service;

import com.example.artist.service.dto.param.ArtistFilterPaginationServiceParam;
import com.example.artist.service.dto.param.ArtistSearchPaginationServiceParam;
import com.example.artist.service.dto.param.ArtistSubscriptionPaginationServiceParam;
import com.example.artist.service.dto.param.ArtistUnsubscriptionPaginationServiceParam;
import com.example.artist.service.dto.request.ArtistFilterPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSearchPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionServiceRequest;
import com.example.artist.service.dto.response.ArtistSubscriptionServiceResponse;
import com.example.artist.service.dto.response.ArtistUnsubscriptionServiceResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationServiceResponse;
import org.example.entity.ArtistSubscription;
import org.example.entity.artist.Artist;
import org.example.usecase.ArtistSubscriptionUseCase;
import org.example.usecase.artist.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService {


    private final ArtistUseCase artistUseCase;
    private final ArtistSubscriptionUseCase artistSubscriptionUseCase;

    public PaginationServiceResponse<ArtistSearchPaginationServiceParam> searchArtist(
        ArtistSearchPaginationServiceRequest request) {
        var response = artistUseCase.searchArtist(request.toDomainRequest());

        List<ArtistSearchPaginationServiceParam> data = response.data().stream()
            .map(ArtistSearchPaginationServiceParam::new)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public PaginationServiceResponse<ArtistFilterPaginationServiceParam> filterArtist(
        ArtistFilterPaginationServiceRequest request
    ) {
        List<ArtistSubscription> subscriptions = artistSubscriptionUseCase.findSubscriptionList(
            request.userId());
        List<UUID> subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();

        var response = artistUseCase.findAllArtistInCursorPagination(
            request.toDomainRequest(subscriptionArtistIds));
        List<ArtistFilterPaginationServiceParam> data = response.data().stream()
            .map(ArtistFilterPaginationServiceParam::new)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

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

    public PaginationServiceResponse<ArtistSubscriptionPaginationServiceParam> findArtistSubscriptions(
        ArtistSubscriptionPaginationServiceRequest request
    ) {
        List<ArtistSubscription> subscriptions = artistSubscriptionUseCase.findSubscriptionList(
            request.userId());
        List<UUID> subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();

        if (subscriptionArtistIds.isEmpty()) {
            return PaginationServiceResponse.of(List.of(), false);
        }

        var response = artistUseCase.findAllArtistInCursorPagination(
            request.toDomainRequest(subscriptionArtistIds));
        List<ArtistSubscriptionPaginationServiceParam> data = response.data().stream()
            .map(ArtistSubscriptionPaginationServiceParam::new)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public PaginationServiceResponse<ArtistUnsubscriptionPaginationServiceParam> findArtistUnsubscriptions(
        ArtistUnsubscriptionPaginationServiceRequest request
    ) {
        List<ArtistSubscription> subscriptions = artistSubscriptionUseCase.findSubscriptionList(
            request.userId());
        List<UUID> subscriptionArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();

        var response = artistUseCase.findAllArtistInCursorPagination(
            request.toDomainRequest(subscriptionArtistIds));
        List<ArtistUnsubscriptionPaginationServiceParam> data = response.data().stream()
            .map(ArtistUnsubscriptionPaginationServiceParam::new)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }
}
