package org.example.repository.ticketing;

import java.util.List;
import java.util.UUID;
import org.example.entity.usershow.TicketingAlert;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketingAlertRepository extends JpaRepository<TicketingAlert, UUID>,
    TicketingAlertQuerydslRepository {

    List<TicketingAlert> findAllByUserIdAndShowIdAndIsDeletedFalse(UUID userId, UUID showId);

    List<TicketingAlert> findAllByUserIdAndIsDeletedFalse(UUID userId);

    void deleteAllByUserId(UUID userId);
}
