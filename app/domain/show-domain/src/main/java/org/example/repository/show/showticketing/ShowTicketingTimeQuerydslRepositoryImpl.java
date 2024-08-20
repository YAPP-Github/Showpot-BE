package org.example.repository.show.showticketing;

import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowTicketingTime.showTicketingTime;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowAlertPaginationDomainRequest;
import org.example.dto.show.response.ShowAlertDomainResponse;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;
import org.example.entity.show.ShowTicketingTime;
import org.example.util.SliceUtil;
import org.example.vo.ShowTicketingAtStatus;
import org.example.vo.TicketingType;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowTicketingTimeQuerydslRepositoryImpl implements
    ShowTicketingTimeQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public ShowAlertPaginationDomainResponse findShowAlerts(
        ShowAlertPaginationDomainRequest request
    ) {
        List<ShowAlertDomainResponse> result = jpaQueryFactory.select(
                Projections.constructor(
                    ShowAlertDomainResponse.class,
                    show.id,
                    show.title,
                    show.startDate,
                    show.endDate,
                    show.location,
                    show.image,
                    showTicketingTime.id,
                    showTicketingTime.ticketingAt
                )
            )
            .from(showTicketingTime)
            .join(showTicketingTime.show, show)
            .where(showTicketingTime.show.id.in(request.showIds())
                .and(getShowAlertsInCursorPagination(request))
            )
            .orderBy(
                showTicketingTime.ticketingAt.asc(),
                showTicketingTime.id.asc()
            )
            .limit(request.size() + 1)
            .fetch();

        Slice<ShowAlertDomainResponse> showSearchDomainSlices = SliceUtil.makeSlice(
            request.size(),
            result
        );

        return ShowAlertPaginationDomainResponse.builder()
            .data(showSearchDomainSlices.getContent())
            .hasNext(showSearchDomainSlices.hasNext())
            .build();
    }

    @Override
    public Optional<ShowTicketingTime> findByShowIdAndTicketingTypeWithShow(
        UUID showId,
        TicketingType type
    ) {
        return Optional.ofNullable(jpaQueryFactory
            .selectFrom(showTicketingTime)
            .join(showTicketingTime.show, show).fetchJoin()
            .where(
                showTicketingTime.show.id.eq(showId)
                    .and(showTicketingTime.ticketingType.eq(type))
                    .and(showTicketingTime.isDeleted.isFalse())
                    .and(show.isDeleted.isFalse())
            )
            .fetchFirst()
        );
    }

    private Predicate getShowAlertsInCursorPagination(
        ShowAlertPaginationDomainRequest request
    ) {
        BooleanExpression wherePredicate = getDefaultPredicateExpression();

        if (request.type().equals(ShowTicketingAtStatus.CONTINUED)) {
            wherePredicate = wherePredicate.and(
                showTicketingTime.ticketingAt.gt(request.now())
            );
        } else if (request.type().equals(ShowTicketingAtStatus.TERMINATED)) {
            wherePredicate = wherePredicate.and(
                showTicketingTime.ticketingAt.lt(request.now())
            );
        }

        if (request.cursorId() != null && request.cursorValue() != null) {
            wherePredicate = wherePredicate.and(
                showTicketingTime.ticketingAt.gt(request.cursorValue())
                    .or(showTicketingTime.ticketingAt.eq(request.cursorValue())
                        .and(showTicketingTime.id.gt(request.cursorId())))
            );

            return wherePredicate;
        }

        return wherePredicate;
    }

    private BooleanExpression getDefaultPredicateExpression() {
        return show.isDeleted.isFalse().and(showTicketingTime.isDeleted.isFalse());
    }
}

