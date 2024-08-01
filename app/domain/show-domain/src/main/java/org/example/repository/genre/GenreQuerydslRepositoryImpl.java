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
import org.example.dto.genre.request.GenreSubscriptionPaginationDomainRequest;
import org.example.dto.genre.request.GenreUnsubscriptionPaginationDomainRequest;
import org.example.dto.genre.response.GenreSubscriptionDomainResponse;
import org.example.dto.genre.response.GenreSubscriptionPaginationDomainResponse;
import org.example.dto.genre.response.GenreUnsubscriptionDomainResponse;
import org.example.dto.genre.response.GenreUnsubscriptionPaginationDomainResponse;
import org.example.entity.genre.Genre;
import org.example.util.SliceUtil;
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
    public GenreSubscriptionPaginationDomainResponse findAllWithCursorPagination(
        GenreSubscriptionPaginationDomainRequest request
    ) {
        List<GenreSubscriptionDomainResponse> genreSubscribeResponses = jpaQueryFactory.select(
                Projections.constructor(
                    GenreSubscriptionDomainResponse.class,
                    genre.id,
                    genre.name
                )
            )
            .from(genre)
            .where(getWhereClauseInCursorPaginationWithSubscription(request.cursor(),
                request.genreIds()))
            .limit(request.size() + 1)
            .fetch();

        Slice<GenreSubscriptionDomainResponse> genreSubscribeSlices = SliceUtil.makeSlice(
            request.size(),
            genreSubscribeResponses
        );

        return GenreSubscriptionPaginationDomainResponse.builder()
            .data(genreSubscribeSlices.getContent())
            .hasNext(genreSubscribeSlices.hasNext())
            .build();
    }

    @Override
    public GenreUnsubscriptionPaginationDomainResponse findAllWithCursorPagination(
        GenreUnsubscriptionPaginationDomainRequest request
    ) {
        List<GenreUnsubscriptionDomainResponse> genreUnsubscriptionResponses = jpaQueryFactory.select(
                Projections.constructor(
                    GenreUnsubscriptionDomainResponse.class,
                    genre.id,
                    genre.name
                )
            )
            .from(genre)
            .where(getWhereClauseInCursorPaginationWithUnsubscription(request.cursor(),
                request.genreIds()))
            .limit(request.size() + 1)
            .fetch();

        Slice<GenreUnsubscriptionDomainResponse> genreUnSubscribeSlices = SliceUtil.makeSlice(
            request.size(),
            genreUnsubscriptionResponses
        );

        return GenreUnsubscriptionPaginationDomainResponse.builder()
            .data(genreUnSubscribeSlices.getContent())
            .hasNext(genreUnSubscribeSlices.hasNext())
            .build();
    }

    private BooleanBuilder getWhereClauseInCursorPaginationWithUnsubscription(
        UUID cursor,
        List<UUID> genreIds
    ) {
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.and(getDefaultPredicateInCursorPagination(cursor));

        if (genreIds.isEmpty()) {
            return whereClause;
        }

        return whereClause.and(genre.id.notIn(genreIds));
    }

    private BooleanBuilder getWhereClauseInCursorPaginationWithSubscription(
        UUID cursor,
        List<UUID> genreIds
    ) {
        BooleanBuilder whereClause = new BooleanBuilder();
        return whereClause.and(getDefaultPredicateInCursorPagination(cursor))
            .and(genre.id.in(genreIds));
    }

    private Predicate getDefaultPredicateInCursorPagination(UUID cursor) {
        BooleanExpression defaultPredicate = genre.isDeleted.isFalse();

        return cursor == null ? defaultPredicate : genre.id.gt(cursor).and(defaultPredicate);
    }
}
