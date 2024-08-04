package org.example.repository.show;

import java.util.UUID;
import org.example.entity.show.ShowTicketingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTicketingTimeRepository extends JpaRepository<ShowTicketingTime, UUID> {

}
