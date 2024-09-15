package org.example.repository.ticketing;


import static org.example.entity.usershow.QTicketingAlert.ticketingAlert;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TicketingAlertQuerydslRepositoryImpl implements TicketingAlertQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public long countValidTicketingAlerts(UUID userId, LocalDateTime now) {
        Long result = jpaQueryFactory.select(ticketingAlert.showId.countDistinct())
            .from(ticketingAlert)
            .where(
                ticketingAlert.isDeleted.isFalse()
                    .and(ticketingAlert.userId.eq(userId))
                    .and(ticketingAlert.alertTime.gt(now))
            )
            .fetchOne();

        return result == null ? 0 : result;
    }
}
