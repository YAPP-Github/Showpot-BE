package org.example.repository.show.showticketing;

import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowTicketingTime.showTicketingTime;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowAlertPaginationDomainRequest;
import org.example.dto.show.response.ShowAlertDomainResponse;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;
import org.example.entity.show.ShowTicketingTime;
import org.example.util.SliceUtil;
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
                .and(getDefaultPredicateInCursorPagination(
                        request.cursorId(),
                        request.cursorValue()
                    )
                )
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

    private Predicate getDefaultPredicateInCursorPagination(
        UUID cursorId,
        LocalDateTime cursorValue
    ) {
        BooleanExpression wherePredicate = show.isDeleted.isFalse()
            .and(showTicketingTime.isDeleted.isFalse())
            .and(showTicketingTime.ticketingAt.gt(LocalDateTime.now()));

        if (cursorId != null && cursorValue != null) {
            wherePredicate = wherePredicate.and(showTicketingTime.ticketingAt.gt(cursorValue)
                .or(showTicketingTime.ticketingAt.eq(cursorValue)
                    .and(showTicketingTime.id.gt(cursorId)))
            );

            return wherePredicate;
        }

        return wherePredicate;
    }
}

