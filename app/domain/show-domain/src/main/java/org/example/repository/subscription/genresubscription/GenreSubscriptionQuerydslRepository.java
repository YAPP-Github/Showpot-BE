package org.example.repository.subscription.genresubscription;

import java.util.List;
import java.util.UUID;
import org.example.entity.usershow.GenreSubscription;

public interface GenreSubscriptionQuerydslRepository {

    List<GenreSubscription> findSubscriptionsByUserId(UUID userId);
}
