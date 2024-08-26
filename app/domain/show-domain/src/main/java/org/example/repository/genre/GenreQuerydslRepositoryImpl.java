package org.example.repository.genre;

import static org.example.entity.genre.QGenre.genre;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.genre.request.GenrePaginationDomainRequest;
import org.example.dto.genre.response.GenreDomainResponse;
import org.example.dto.genre.response.GenrePaginationDomainResponse;
import org.example.entity.genre.Genre;
import org.example.util.SliceUtil;
import org.example.vo.SubscriptionStatus;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GenreQuerydslRepositoryImpl implements GenreQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Genre> findAllInId(List<UUID> ids) {
        return jpaQueryFactory
            .selectFrom(genre)
            .where(genre.id.in(ids).and(genre.isDeleted.isFalse()))
            .fetch();
    }

    @Override
    public GenrePaginationDomainResponse findAllWithCursorPagination(
        GenrePaginationDomainRequest request
    ) {
        List<GenreDomainResponse> genreUnsubscriptionResponses = jpaQueryFactory.select(
                Projections.constructor(
                    GenreDomainResponse.class,
                    genre.id,
                    genre.name
                )
            )
            .from(genre)
            .where(
                getWhereClauseInCursorPagination(
                    request.subscriptionStatus(),
                    request.cursor(),
                    request.genreIds()
                )
            )
            .limit(request.size() + 1)
            .fetch();

        Slice<GenreDomainResponse> genreUnSubscribeSlices = SliceUtil.makeSlice(
            request.size(),
            genreUnsubscriptionResponses
        );

        return GenrePaginationDomainResponse.builder()
            .data(genreUnSubscribeSlices.getContent())
            .hasNext(genreUnSubscribeSlices.hasNext())
            .build();
    }

    private BooleanBuilder getWhereClauseInCursorPagination(
        SubscriptionStatus status,
        UUID cursor,
        List<UUID> genreIds
    ) {
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.and(getDefaultPredicateInCursorPagination(cursor));

        switch (status) {
            case SUBSCRIBED -> whereClause.and(genre.id.in(genreIds));
            case UNSUBSCRIBED -> whereClause.and(genre.id.notIn(genreIds));
            default -> {
                return whereClause;
            }
        }

        return whereClause;
    }

    private Predicate getDefaultPredicateInCursorPagination(UUID cursor) {
        BooleanExpression defaultPredicate = genre.isDeleted.isFalse();

        return cursor == null ? defaultPredicate : genre.id.gt(cursor).and(defaultPredicate);
    }
}
