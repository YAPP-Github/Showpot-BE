package org.example.repository.show.showticketing;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.entity.show.ShowTicketingTime;
import org.example.vo.TicketingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTicketingTimeRepository extends JpaRepository<ShowTicketingTime, UUID>,
    ShowTicketingTimeQuerydslRepository {

    List<ShowTicketingTime> findAllByShowIdAndIsDeletedFalse(UUID showId);

    Optional<ShowTicketingTime> findByShowIdAndTicketingTypeAndIsDeletedFalse(
        UUID showId,
        TicketingType type
    );
}
