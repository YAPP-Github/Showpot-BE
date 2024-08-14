package org.example.repository.ticketing;

import static org.example.entity.QTicketingAlert.ticketingAlert;
import static org.example.entity.QUser.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.TicketingAlertsDomainResponse;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TicketingAlertQuerydslRepositoryImpl implements TicketingAlertQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<TicketingAlertsDomainResponse> findTicketingAlertsWithUserFcmToken(
        UUID userId,
        UUID showId
    ) {
        return jpaQueryFactory.select(
                Projections.constructor(
                    TicketingAlertsDomainResponse.class,
                    user.fcmToken,
                    ticketingAlert.name,
                    ticketingAlert.alertTime,
                    ticketingAlert.showId
                )
            )
            .from(ticketingAlert)
            .join(user).on(ticketingAlert.userId.eq(userId), user.isDeleted.isFalse())
            .where(
                ticketingAlert.userId.eq(userId),
                ticketingAlert.showId.eq(showId),
                ticketingAlert.isDeleted.isFalse()
            )
            .fetch();
    }
}
