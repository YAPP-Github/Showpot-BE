package com.example.artist.service;

import com.example.artist.service.dto.param.ArtistSearchPaginationServiceParam;
import com.example.artist.service.dto.param.ArtistSubscriptionPaginationServiceParam;
import com.example.artist.service.dto.param.ArtistUnsubscriptionPaginationServiceParam;
import com.example.artist.service.dto.request.ArtistFilterTotalCountServiceRequest;
import com.example.artist.service.dto.request.ArtistSearchPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionServiceRequest;
import com.example.artist.service.dto.response.ArtistFilterTotalCountServiceResponse;
import com.example.artist.service.dto.response.ArtistSubscriptionServiceResponse;
import com.example.artist.service.dto.response.ArtistUnsubscriptionServiceResponse;
import com.example.artist.service.dto.response.NumberOfSubscribedArtistServiceResponse;
import com.example.publish.MessagePublisher;
import com.example.publish.message.ArtistServiceMessage;
import com.example.publish.message.ArtistSubscriptionServiceMessage;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationServiceResponse;
import org.example.entity.ArtistSubscription;
import org.example.entity.artist.Artist;
import org.example.usecase.artist.ArtistUseCase;
import org.example.usecase.subscription.ArtistSubscriptionUseCase;
import org.example.usecase.user.UserUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService {


    private final ArtistUseCase artistUseCase;
    private final ArtistSubscriptionUseCase artistSubscriptionUseCase;
    private final UserUseCase userUseCase;
    private final MessagePublisher messagePublisher;

    public PaginationServiceResponse<ArtistSearchPaginationServiceParam> searchArtist(
        ArtistSearchPaginationServiceRequest request
    ) {
        var response = artistUseCase.searchArtist(request.toDomainRequest());

        List<UUID> subscribedArtistIds = request.userId() == null
            ? List.of()
            : artistSubscriptionUseCase.findArtistSubscriptionByUserId(request.userId()).stream()
                .map(ArtistSubscription::getArtistId)
                .toList();

        List<ArtistSearchPaginationServiceParam> data = response.data().stream()
            .map(artistResponse -> ArtistSearchPaginationServiceParam.from(
                    artistResponse,
                    subscribedArtistIds
                )
            )
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public ArtistFilterTotalCountServiceResponse filterArtistTotalCount(
        ArtistFilterTotalCountServiceRequest request
    ) {
        List<UUID> subscriptionArtistIds = getSubscriptionArtistIds(request.userId());

        try {
            return new ArtistFilterTotalCountServiceResponse(
                artistUseCase.findFilterArtistTotalCount(
                    request.toDomainRequest(subscriptionArtistIds)
                )
            );
        } catch (NoSuchElementException e) {
            return ArtistFilterTotalCountServiceResponse.noneTotalCount();
        }
    }

    public ArtistSubscriptionServiceResponse subscribe(ArtistSubscriptionServiceRequest request) {
        var existArtistsInRequest = artistUseCase.findAllArtistInIds(request.artistIds());
        var existArtistIdsInRequest = existArtistsInRequest.stream()
            .map(Artist::getId)
            .toList();

        var subscriptions = artistSubscriptionUseCase.subscribe(
            existArtistIdsInRequest,
            request.userId()
        );
        var subscribedArtistIds = subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();

        var subscribedArtistMessage = artistUseCase.findAllArtistInIds(subscribedArtistIds)
            .stream().map(ArtistServiceMessage::from)
            .toList();
        var userFcmToken = userUseCase.findUserFcmTokensByUserId(request.userId());

        messagePublisher.publishArtistSubscription(
            "artistSubscription",
            ArtistSubscriptionServiceMessage.from(
                userFcmToken,
                subscribedArtistMessage
            )
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
        var unsubscribedArtists = artistSubscriptionUseCase.unsubscribe(
            request.artistIds(),
            request.userId()
        );
        var unsubscribedArtistMessage = unsubscribedArtists.stream()
            .map(ArtistServiceMessage::toUnsubscribe)
            .toList();

        var userFcmToken = userUseCase.findUserFcmTokensByUserId(request.userId());

        messagePublisher.publishArtistSubscription(
            "artistUnsubscription",
            ArtistSubscriptionServiceMessage.from(
                userFcmToken,
                unsubscribedArtistMessage
            )
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
            request.userId()
        );
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
        List<UUID> subscriptionArtistIds = request.userId() == null
            ? List.of()
            : getSubscriptionArtistIds(request.userId());

        var response = artistUseCase.findAllArtistInCursorPagination(
            request.toDomainRequest(subscriptionArtistIds));
        List<ArtistUnsubscriptionPaginationServiceParam> data = response.data().stream()
            .map(ArtistUnsubscriptionPaginationServiceParam::new)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public NumberOfSubscribedArtistServiceResponse countSubscribedArtists(UUID userId) {
        return NumberOfSubscribedArtistServiceResponse.from(
            artistSubscriptionUseCase.countSubscribedArtists(userId)
        );
    }

    private List<UUID> getSubscriptionArtistIds(UUID userId) {
        List<ArtistSubscription> subscriptions = artistSubscriptionUseCase.findSubscriptionList(userId);

        return subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();
    }
}
