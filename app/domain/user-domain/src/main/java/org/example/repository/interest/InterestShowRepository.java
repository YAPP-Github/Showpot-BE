package org.example.repository.interest;

import java.util.Optional;
import java.util.UUID;
import org.example.entity.InterestShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestShowRepository extends JpaRepository<InterestShow, UUID>, InterestShowQuerydslRepository {

    Optional<InterestShow> findByShowIdAndUserId(UUID showId, UUID userId);

    Optional<InterestShow> findByShowIdAndUserIdAndIsDeletedFalse(UUID showId, UUID userId);

    Long countInterestShowByUserIdAndIsDeletedFalse(UUID userId);

    void deleteAllByUserId(UUID userId);
}
