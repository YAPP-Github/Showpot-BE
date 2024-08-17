package org.example.repository.show.showticketing;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.entity.show.ShowTicketingTime;
import org.example.vo.TicketingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShowTicketingTimeRepository extends JpaRepository<ShowTicketingTime, UUID>,
    ShowTicketingTimeQuerydslRepository {

    List<ShowTicketingTime> findAllByShowIdAndIsDeletedFalse(UUID showId);

    Optional<ShowTicketingTime> findByShowIdAndTicketingTypeAndIsDeletedFalse(
        UUID showId,
        TicketingType type
    );

    @Query(
        "SELECT stt FROM ShowTicketingTime stt JOIN FETCH stt.show "
            + "WHERE stt.show.id = :showId AND stt.ticketingType = :type "
            + "AND stt.isDeleted = false"
    )
    Optional<ShowTicketingTime> findByShowIdAndTicketingTypeWithShow(
        @Param("showId") UUID showId,
        @Param("type") TicketingType type
    );
}
