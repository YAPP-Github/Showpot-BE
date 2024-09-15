package org.example.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.entity.usershow.GenreSubscription;
import org.example.repository.subscription.genresubscription.GenreSubscriptionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class GenreSubscriptionUseCase {

    private final GenreSubscriptionRepository genreSubscriptionRepository;

    @Transactional
    public List<GenreSubscription> subscribe(List<UUID> requestGenreIds, UUID userId) {
        var subscribedResult = new ArrayList<GenreSubscription>();
        var newSubscriptions = new ArrayList<GenreSubscription>();
        var allSubscriptionByGenreId = genreSubscriptionRepository.findAllByUserId(userId)
            .stream()
            .collect(Collectors.toMap(GenreSubscription::getGenreId, it -> it));

        for (UUID genreId : requestGenreIds) {
            if (allSubscriptionByGenreId.containsKey(genreId)) {
                var existSubscription = allSubscriptionByGenreId.get(genreId);
                existSubscription.subscribe();
                subscribedResult.add(existSubscription);
                continue;
            }

            newSubscriptions.add(GenreSubscription.builder()
                .userId(userId)
                .genreId(genreId)
                .build()
            );
        }

        genreSubscriptionRepository.saveAll(newSubscriptions);
        subscribedResult.addAll(newSubscriptions);
        return subscribedResult;
    }

    public List<GenreSubscription> findSubscriptions(UUID userId) {
        return genreSubscriptionRepository.findByUserIdAndIsDeletedFalse(userId);
    }

    @Transactional
    public List<GenreSubscription> unsubscribe(List<UUID> genreIds, UUID userId) {
        var subscriptions = genreSubscriptionRepository.findSubscriptionsByUserId(userId);
        var filteredSubscriptions = subscriptions.stream()
            .filter(it -> genreIds.contains(it.getGenreId()))
            .toList();

        filteredSubscriptions.forEach(GenreSubscription::unsubscribe);

        return filteredSubscriptions;
    }

    public long countSubscribedGenres(UUID userId) {
        Long result = genreSubscriptionRepository.countByUserIdAndIsDeletedFalse(userId);
        return result == null ? 0 : result;
    }
}
