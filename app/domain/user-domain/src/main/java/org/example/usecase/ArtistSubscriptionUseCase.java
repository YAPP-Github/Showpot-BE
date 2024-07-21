package org.example.usecase;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.ArtistSubscription;
import org.example.repository.subscription.ArtistSubscriptionRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistSubscriptionUseCase {

    private final ArtistSubscriptionRepository artistSubscriptionRepository;

    public void subscribe(List<ArtistSubscription> subscriptions) {
        artistSubscriptionRepository.saveAll(subscriptions);
    }

    public List<ArtistSubscription> findSubscriptionList(UUID userId) {
        return artistSubscriptionRepository.findByUserId(userId);
    }
}
