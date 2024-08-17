package org.example.repository.show.showticketing;

import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowTicketingTime.showTicketingTime;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowAlertPaginationDomainRequest;
import org.example.dto.show.response.ShowAlertDomainResponse;
import org.example.dto.show.response.ShowAlertPaginationDomainResponse;
import org.example.util.SliceUtil;
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
                    show.image
                )
            )
            .from(showTicketingTime)
            .join(showTicketingTime.show, show)
            .where(showTicketingTime.show.id.in(request.showIds())
                .and(getDefaultPredicateInCursorPagination(request.cursorId()))
            )
            .orderBy(showTicketingTime.ticketingAt.asc())
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

    private Predicate getDefaultPredicateInCursorPagination(UUID cursor) {
        BooleanExpression defaultPredicate = show.isDeleted.isFalse()
            .and(showTicketingTime.isDeleted.isFalse())
            .and(showTicketingTime.ticketingAt.gt(LocalDateTime.now()));

        return cursor == null ? defaultPredicate : show.id.gt(cursor).and(defaultPredicate);
    }
}

