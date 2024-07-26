package org.example.usecase;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.GenreSubscription;
import org.example.repository.subscription.GenreSubscriptionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class GenreSubscriptionUseCase {

    private final GenreSubscriptionRepository genreSubscriptionRepository;

    @Transactional
    public void subscribe(List<GenreSubscription> subscriptions) {
        genreSubscriptionRepository.saveAll(subscriptions);
    }

    public List<GenreSubscription> findSubscriptionList(UUID userId) {
        return genreSubscriptionRepository.findByUserId(userId);
    }

    @Transactional
    public List<GenreSubscription> unsubscribe(List<UUID> genreIds, UUID userId) {
        var subscriptions = genreSubscriptionRepository.findSubscriptionsByUserId(userId);
        var filteredSubscription = subscriptions.stream()
            .filter(it -> genreIds.contains(it.getGenreId()))
            .toList();

        filteredSubscription.forEach(GenreSubscription::unsubscribe);

        return filteredSubscription;
    }
}
