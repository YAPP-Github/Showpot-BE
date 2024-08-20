package org.example.repository.ticketing;

import static org.example.entity.QTicketingAlert.ticketingAlert;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TicketingAlertQuerydslRepositoryImpl implements TicketingAlertQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<UUID> findAlertShowIdsByUserId(UUID userId) {
        return jpaQueryFactory
            .selectDistinct(ticketingAlert.showId)
            .from(ticketingAlert)
            .where(ticketingAlert.userId.eq(userId).and(ticketingAlert.isDeleted.isFalse()))
            .fetch();
    }
}
