package com.example.genre.service;

import com.example.genre.service.dto.param.GenreSubscriptionPaginationServiceParam;
import com.example.genre.service.dto.param.GenreUnsubscriptionPaginationServiceParam;
import com.example.genre.service.dto.request.GenreSubscriptionPaginationServiceRequest;
import com.example.genre.service.dto.request.GenreSubscriptionServiceRequest;
import com.example.genre.service.dto.request.GenreUnsubscriptionPaginationServiceRequest;
import com.example.genre.service.dto.request.GenreUnsubscriptionServiceRequest;
import com.example.genre.service.dto.response.GenreSubscriptionServiceResponse;
import com.example.genre.service.dto.response.GenreUnsubscriptionServiceResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.genre.response.GenreSubscriptionPaginationDomainResponse;
import org.example.dto.genre.response.GenreUnsubscriptionPaginationDomainResponse;
import org.example.dto.response.PaginationServiceResponse;
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
        List<Genre> existGenresInRequest = genreUseCase.findAllGenresInIds(request.genreIds());
        List<UUID> existGenreIdsInRequest = existGenresInRequest.stream()
            .map(Genre::getId)
            .toList();

        List<GenreSubscription> subscriptions = genreSubscriptionUseCase.subscribe(
            existGenreIdsInRequest,
            request.userId()
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
        List<GenreSubscription> unsubscriptionGenres = genreSubscriptionUseCase.unsubscribe(
            request.genreIds(),
            request.userId()
        );

        return GenreUnsubscriptionServiceResponse.builder()
            .successUnsubscriptionGenreIds(
                unsubscriptionGenres.stream()
                    .map(GenreSubscription::getGenreId)
                    .toList()
            )
            .build();
    }

    public PaginationServiceResponse<GenreSubscriptionPaginationServiceParam> findGenreSubscriptions(
        GenreSubscriptionPaginationServiceRequest request
    ) {
        List<GenreSubscription> subscriptions = genreSubscriptionUseCase.findSubscriptions(
            request.userId());
        List<UUID> subscriptionGenreIds = subscriptions.stream()
            .map(GenreSubscription::getGenreId)
            .toList();

        if (subscriptionGenreIds.isEmpty()) {
            return PaginationServiceResponse.of(List.of(), false);
        }

        GenreSubscriptionPaginationDomainResponse response = genreUseCase.findGenreSubscriptionWithCursorPagination(
            request.toDomainRequest(subscriptionGenreIds));
        List<GenreSubscriptionPaginationServiceParam> data = response.data().stream()
            .map(GenreSubscriptionPaginationServiceParam::new)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public PaginationServiceResponse<GenreUnsubscriptionPaginationServiceParam> findGenreUnSubscriptions(
        GenreUnsubscriptionPaginationServiceRequest request
    ) {
        List<GenreSubscription> subscriptions = genreSubscriptionUseCase.findSubscriptions(
            request.userId());
        List<UUID> subscriptionGenreIds = subscriptions.stream()
            .map(GenreSubscription::getGenreId)
            .toList();

        GenreUnsubscriptionPaginationDomainResponse response = genreUseCase.findGenreUnsubscriptionWithCursorPagination(
            request.toDomainRequest(subscriptionGenreIds));
        List<GenreUnsubscriptionPaginationServiceParam> data = response.data().stream()
            .map(GenreUnsubscriptionPaginationServiceParam::new)
            .toList();
        return PaginationServiceResponse.of(data, response.hasNext());
    }
}
