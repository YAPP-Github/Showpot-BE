package org.example.repository.subscription;

import java.util.List;
import java.util.UUID;
import org.example.entity.GenreSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreSubscriptionRepository extends JpaRepository<GenreSubscription, UUID>,
    GenreSubscriptionQuerydslRepository {

    List<GenreSubscription> findByUserId(UUID userId);
}
