package org.example.usecase.subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.entity.ArtistSubscription;
import org.example.repository.subscription.artistsubscription.ArtistSubscriptionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArtistSubscriptionUseCase {

    private final ArtistSubscriptionRepository artistSubscriptionRepository;

    public List<ArtistSubscription> findSubscriptionList(UUID userId) {
        return artistSubscriptionRepository.findSubscriptionList(userId);
    }

    @Transactional
    public List<ArtistSubscription> subscribe(List<UUID> requestArtistIds, UUID userId) {
        var subscribedResult = new ArrayList<ArtistSubscription>();
        var newSubscriptions = new ArrayList<ArtistSubscription>();
        var allSubscriptionByArtistId = artistSubscriptionRepository.findAllByUserId(userId)
            .stream()
            .collect(Collectors.toMap(ArtistSubscription::getArtistId, it -> it));

        for (UUID artistId : requestArtistIds) {
            if (allSubscriptionByArtistId.containsKey(artistId)) {
                var existSubscription = allSubscriptionByArtistId.get(artistId);
                existSubscription.subscribe();
                subscribedResult.add(existSubscription);
                continue;
            }

            newSubscriptions.add(ArtistSubscription.builder()
                .userId(userId)
                .artistId(artistId)
                .build()
            );
        }

        artistSubscriptionRepository.saveAll(newSubscriptions);
        subscribedResult.addAll(newSubscriptions);
        return subscribedResult;
    }

    @Transactional
    public List<ArtistSubscription> unsubscribe(List<UUID> artistIds, UUID userId) {
        var subscriptions = artistSubscriptionRepository.findSubscriptionList(userId);
        var filteredSubscription = subscriptions.stream()
            .filter(it -> artistIds.contains(it.getArtistId()))
            .toList();

        filteredSubscription.forEach(ArtistSubscription::unsubscribe);

        return filteredSubscription;
    }

    public List<ArtistSubscription> findArtistSubscriptionByUserId(UUID userId) {
        return artistSubscriptionRepository.findAllByUserIdAndIsDeletedFalse(userId);
    }


    public long countSubscribedArtists(UUID userId) {
        Long result = artistSubscriptionRepository.countByUserIdAndIsDeletedFalse(userId);
        return result == null ? 0 : result;
    }
}
