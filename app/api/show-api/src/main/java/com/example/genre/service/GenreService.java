package com.example.genre.service;

import com.example.genre.service.dto.request.GenreSubscriptionPaginationServiceRequest;
import com.example.genre.service.dto.request.GenreSubscriptionServiceRequest;
import com.example.genre.service.dto.request.GenreUnsubscriptionServiceRequest;
import com.example.genre.service.dto.response.GenreSubscribeServiceResponse;
import com.example.genre.service.dto.response.GenreSubscriptionPaginationServiceResponse;
import com.example.genre.service.dto.response.GenreSubscriptionServiceResponse;
import com.example.genre.service.dto.response.GenreUnSubscriptionServiceResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.dto.genre.response.GenreSubscriptionPaginationResponse;
import org.example.entity.GenreSubscription;
import org.example.entity.genre.Genre;
import org.example.usecase.GenreSubscriptionUseCase;
import org.example.usecase.genre.GenreUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreUseCase genreUseCase;
    private final GenreSubscriptionUseCase genreSubscriptionUseCase;

    public GenreSubscriptionServiceResponse subscribe(GenreSubscriptionServiceRequest request) {
        List<Genre> existGenres = genreUseCase.findAllGenresInIds(request.genreIds());

        List<GenreSubscription> newGenreSubscription = getNewGenreSubscription(
            existGenres,
            request.userId()
        );

        genreSubscriptionUseCase.subscribe(newGenreSubscription);

        return GenreSubscriptionServiceResponse.builder()
            .successSubscriptionGenreIds(
                newGenreSubscription.stream()
                    .map(GenreSubscription::getGenreId)
                    .toList()
            )
            .build();
    }

    private List<GenreSubscription> getNewGenreSubscription(
        List<Genre> genres,
        UUID userId
    ) {
        var existSubscriptionByUserId = getExistSubscriptionByUserId(userId);
        return genres.stream()
            .filter(genre -> !existSubscriptionByUserId.containsKey(genre.getId()))
            .map(genre ->
                GenreSubscription.builder()
                    .genreId(genre.getId())
                    .userId(userId)
                    .build()
            ).toList();
    }

    private Map<UUID, GenreSubscription> getExistSubscriptionByUserId(UUID userId) {
        return genreSubscriptionUseCase.findSubscriptionList(userId)
            .stream()
            .collect(
                Collectors.toMap(
                    GenreSubscription::getGenreId,
                    genreSubscription -> genreSubscription
                )
            );
    }

    public GenreUnSubscriptionServiceResponse unsubscribe(
        GenreUnsubscriptionServiceRequest request) {
        List<GenreSubscription> unsubscribedGenre = genreSubscriptionUseCase.unsubscribe(
            request.genreIds(), request.userId());

        return GenreUnSubscriptionServiceResponse.builder()
            .successUnSubscriptionGenreIds(
                unsubscribedGenre.stream()
                    .map(GenreSubscription::getGenreId)
                    .toList()
            )
            .build();
    }

    public GenreSubscriptionPaginationServiceResponse findGenreSubscriptions(
        GenreSubscriptionPaginationServiceRequest request) {
        List<GenreSubscription> subscriptions = genreSubscriptionUseCase.findSubscriptionList(
            request.userId());
        List<UUID> subscriptionGenreIds = subscriptions.stream()
            .map(GenreSubscription::getGenreId)
            .toList();

        if (subscriptionGenreIds.isEmpty()) {
            return GenreSubscriptionPaginationServiceResponse.builder()
                .data(List.of())
                .hasNext(false)
                .build();
        }

        GenreSubscriptionPaginationResponse response = genreUseCase.findGenreSubscriptionsWithCursorPagination(
            request.toDomainRequest(subscriptionGenreIds));
        List<GenreSubscribeServiceResponse> data = response.data().stream()
            .map(GenreSubscribeServiceResponse::new)
            .toList();

        return GenreSubscriptionPaginationServiceResponse.builder()
            .data(data)
            .hasNext(response.hasNext())
            .build();
    }
}
