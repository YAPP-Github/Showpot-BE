package com.example.artist.service;

import com.example.artist.service.dto.param.ArtistSearchPaginationServiceParam;
import com.example.artist.service.dto.param.ArtistSubscriptionPaginationServiceParam;
import com.example.artist.service.dto.param.ArtistUnsubscriptionPaginationServiceParam;
import com.example.artist.service.dto.request.ArtistSearchPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionServiceRequest;
import com.example.artist.service.dto.response.ArtistSubscriptionServiceResponse;
import com.example.artist.service.dto.response.ArtistUnsubscriptionServiceResponse;
import com.example.artist.service.dto.response.NumberOfSubscribedArtistServiceResponse;
import com.example.pub.MessagePublisher;
import com.example.pub.message.ArtistServiceMessage;
import com.example.pub.message.ArtistSubscriptionServiceMessage;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.CursorApiResponse;
import org.example.dto.response.PaginationServiceResponse;
import org.example.entity.artist.Artist;
import org.example.entity.usershow.ArtistSubscription;
import org.example.usecase.ArtistSubscriptionUseCase;
import org.example.usecase.ArtistUseCase;
import org.example.usecase.UserUseCase;
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
            : artistSubscriptionUseCase.findArtistSubscriptionByUserId(request.userId())
                .stream()
                .map(ArtistSubscription::getArtistId)
                .toList();

        List<ArtistSearchPaginationServiceParam> data = response.data().stream()
            .map(artistResponse -> ArtistSearchPaginationServiceParam.from(
                    artistResponse,
                    subscribedArtistIds
                )
            )
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext(),
            CursorApiResponse.toCursorId(response.offset())
        );
    }

    public ArtistSubscriptionServiceResponse subscribe(ArtistSubscriptionServiceRequest request) {
        List<Artist> requestArtist = artistUseCase.findOrCreateArtistBySpotifyId(
            request.spotifyArtistIds()
        );

        List<UUID> requestArtistIds = requestArtist.stream()
            .map(Artist::getId)
            .toList();

        var subscribedArtistIds = artistSubscriptionUseCase
            .subscribe(requestArtistIds, request.userId()).stream()
            .map(ArtistSubscription::getArtistId)
            .toList();

        var subscribedArtistMessage = requestArtist
            .stream()
            .filter(artist -> subscribedArtistIds.contains(artist.getId()))
            .map(ArtistServiceMessage::from)
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
                subscribedArtistMessage.stream()
                    .map(ArtistServiceMessage::id)
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
        List<ArtistSubscription> subscriptions = artistSubscriptionUseCase.findSubscriptionList(
            userId);

        return subscriptions.stream()
            .map(ArtistSubscription::getArtistId)
            .toList();
    }
}
