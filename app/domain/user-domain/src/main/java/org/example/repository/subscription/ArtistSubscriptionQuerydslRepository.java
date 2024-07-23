package org.example.repository.subscription;

import java.util.List;
import java.util.UUID;
import org.example.entity.ArtistSubscription;

public interface ArtistSubscriptionQuerydslRepository {

    List<ArtistSubscription> findSubscriptionList(UUID userId);

    List<ArtistSubscription> findUnsubscriptionList(UUID userId);
}
