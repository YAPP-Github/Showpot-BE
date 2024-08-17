package org.example.repository.interest;

import static org.example.entity.QInterestShow.interestShow;
import static org.example.entity.QTicketingAlert.ticketingAlert;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;
import org.example.entity.InterestShow;
import org.example.entity.TicketingAlert;
import org.example.util.SliceUtil;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InterestShowQuerydslRepositoryImpl implements InterestShowQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public InterestShowPaginationDomainResponse findInterestShowList(
        InterestShowPaginationDomainRequest request
    ) {
        var data = jpaQueryFactory.selectFrom(interestShow)
            .where(getInterestShowPaginationConditions(request))
            .orderBy(
                interestShow.updatedAt.desc(),
                interestShow.id.asc()
            )
            .limit(request.size() + 1)
            .fetch();

        Slice<InterestShow> interestShowSlice = SliceUtil.makeSlice(request.size(), data);

        return InterestShowPaginationDomainResponse.builder()
            .hasNext(interestShowSlice.hasNext())
            .data(interestShowSlice.getContent())
            .build();
    }

    @Override
    public List<TicketingAlert> findValidTicketingAlerts(UUID userId, LocalDateTime now) {
        return jpaQueryFactory.selectFrom(ticketingAlert)
            .where(
                ticketingAlert.isDeleted.isFalse()
                    .and(ticketingAlert.userId.eq(userId))
                    .and(ticketingAlert.alertTime.gt(now))
            )
            .fetch();
    }

    private BooleanExpression getInterestShowPaginationConditions(InterestShowPaginationDomainRequest request) {
        BooleanExpression whereConditions = interestShow.userId.eq(request.userId())
            .and(interestShow.isDeleted.isFalse());

        if (request.cursorId() != null && request.cursorValue() != null) {
            whereConditions = whereConditions.and(
                interestShow.updatedAt.lt(request.cursorValue())
                    .or(
                        interestShow.updatedAt.eq(request.cursorValue())
                            .and(interestShow.id.gt(request.cursorId()))
                    )
            );
        }

        return whereConditions;
    }
}
