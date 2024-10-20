package com.example.genre.service;

import com.example.genre.service.dto.param.GenrePaginationServiceParam;
import com.example.genre.service.dto.param.GenreSubscriptionPaginationServiceParam;
import com.example.genre.service.dto.param.GenreUnsubscriptionPaginationServiceParam;
import com.example.genre.service.dto.request.GenrePaginationServiceRequest;
import com.example.genre.service.dto.request.GenreSubscriptionPaginationServiceRequest;
import com.example.genre.service.dto.request.GenreSubscriptionServiceRequest;
import com.example.genre.service.dto.request.GenreUnsubscriptionPaginationServiceRequest;
import com.example.genre.service.dto.request.GenreUnsubscriptionServiceRequest;
import com.example.genre.service.dto.response.GenreSubscriptionServiceResponse;
import com.example.genre.service.dto.response.GenreUnsubscriptionServiceResponse;
import com.example.genre.service.dto.response.NumberOfSubscribedGenreServiceResponse;
import com.example.pub.MessagePublisher;
import com.example.pub.message.GenreServiceMessage;
import com.example.pub.message.GenreSubscriptionServiceMessage;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.genre.response.GenrePaginationDomainResponse;
import org.example.dto.response.PaginationServiceResponse;
import org.example.entity.genre.Genre;
import org.example.entity.usershow.GenreSubscription;
import org.example.usecase.GenreSubscriptionUseCase;
import org.example.usecase.GenreUseCase;
import org.example.usecase.UserUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreUseCase genreUseCase;
    private final GenreSubscriptionUseCase genreSubscriptionUseCase;
    private final UserUseCase userUseCase;
    private final MessagePublisher messagePublisher;

    public GenreSubscriptionServiceResponse subscribe(GenreSubscriptionServiceRequest request) {
        var existGenresInRequest = genreUseCase.findAllGenresInIds(request.genreIds());
        var existGenreIdsInRequest = existGenresInRequest.stream()
            .map(Genre::getId)
            .toList();

        var subscriptions = genreSubscriptionUseCase.subscribe(
            existGenreIdsInRequest,
            request.userId()
        );
        var subscribedGenreIds = subscriptions.stream()
            .map(GenreSubscription::getGenreId)
            .toList();

        var subscribedGenreMessage = genreUseCase.findAllGenresInIds(subscribedGenreIds)
            .stream().map(GenreServiceMessage::from)
            .toList();
        var userFcmToken = userUseCase.findUserFcmTokensByUserId(request.userId());

        messagePublisher.publishGenreSubscription(
            "genreSubscription",
            GenreSubscriptionServiceMessage.from(
                userFcmToken,
                subscribedGenreMessage
            )
        );

        return GenreSubscriptionServiceResponse.builder()
            .successSubscriptionGenreIds(
                subscriptions.stream()
                    .map(GenreSubscription::getGenreId)
                    .toList()
            )
            .build();
    }

    public GenreUnsubscriptionServiceResponse unsubscribe(
        GenreUnsubscriptionServiceRequest request
    ) {
        var unsubscriptionGenres = genreSubscriptionUseCase.unsubscribe(
            request.genreIds(),
            request.userId()
        );
        var unsubscribedGenreMessage = unsubscriptionGenres.stream()
            .map(GenreServiceMessage::toUnsubscribe)
            .toList();

        var userFcmToken = userUseCase.findUserFcmTokensByUserId(request.userId());

        messagePublisher.publishGenreSubscription(
            "genreUnsubscription",
            GenreSubscriptionServiceMessage.from(
                userFcmToken,
                unsubscribedGenreMessage
            )
        );

        return GenreUnsubscriptionServiceResponse.builder()
            .successUnsubscriptionGenreIds(
                unsubscriptionGenres.stream()
                    .map(GenreSubscription::getGenreId)
                    .toList()
            )
            .build();
    }

    public PaginationServiceResponse<GenrePaginationServiceParam> findGenres(
        GenrePaginationServiceRequest request
    ) {
        List<UUID> subscriptionGenreIds = request.userId() == null
            ? List.of()
            : getSubscriptionGenreIds(request.userId());

        GenrePaginationDomainResponse response = genreUseCase.findGenreWithCursorPagination(
            request.toDomainRequest());

        List<GenrePaginationServiceParam> data = response.data().stream()
            .map(genre -> GenrePaginationServiceParam.of(genre, subscriptionGenreIds))
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public PaginationServiceResponse<GenreSubscriptionPaginationServiceParam> findGenreSubscriptions(
        GenreSubscriptionPaginationServiceRequest request
    ) {
        List<UUID> subscriptionGenreIds = getSubscriptionGenreIds(request.userId());

        if (subscriptionGenreIds.isEmpty()) {
            return PaginationServiceResponse.of(List.of(), false);
        }

        GenrePaginationDomainResponse response = genreUseCase.findGenreWithCursorPagination(
            request.toDomainRequest(subscriptionGenreIds));
        List<GenreSubscriptionPaginationServiceParam> data = response.data().stream()
            .map(GenreSubscriptionPaginationServiceParam::new)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public PaginationServiceResponse<GenreUnsubscriptionPaginationServiceParam> findGenreUnSubscriptions(
        GenreUnsubscriptionPaginationServiceRequest request
    ) {
        List<UUID> subscriptionGenreIds = getSubscriptionGenreIds(request.userId());

        GenrePaginationDomainResponse response = genreUseCase.findGenreWithCursorPagination(
            request.toDomainRequest(subscriptionGenreIds));
        List<GenreUnsubscriptionPaginationServiceParam> data = response.data().stream()
            .map(GenreUnsubscriptionPaginationServiceParam::new)
            .toList();
        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public NumberOfSubscribedGenreServiceResponse countSubscribedGenres(UUID uuid) {
        return NumberOfSubscribedGenreServiceResponse.from(
            genreSubscriptionUseCase.countSubscribedGenres(uuid)
        );
    }

    private List<UUID> getSubscriptionGenreIds(UUID userId) {
        List<GenreSubscription> subscriptions = genreSubscriptionUseCase.findSubscriptions(userId);

        return subscriptions.stream()
            .map(GenreSubscription::getGenreId)
            .toList();
    }
}
