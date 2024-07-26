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
import org.example.dto.genre.request.GenreSubscriptionPaginationRequest;
import org.example.dto.genre.response.GenreSubscribeResponse;
import org.example.dto.genre.response.GenreSubscriptionPaginationResponse;
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
            .where(genre.id.in(ids))
            .fetch();
    }

    @Override
    public GenreSubscriptionPaginationResponse findAllWithCursorPagination(
        GenreSubscriptionPaginationRequest request) {
        List<GenreSubscribeResponse> genreSubscribeResponses = jpaQueryFactory.select(
                Projections.constructor(
                    GenreSubscribeResponse.class,
                    genre.id,
                    genre.name
                )
            ).from(genre)
            .where(getWhereClauseInCursorPagination(request.cursor(), request.genreIds()))
            .limit(request.size() + 1)
            .fetch();

        Slice<GenreSubscribeResponse> genreSubscribeSlices = SliceUtil.makeSlice(request.size(),
            genreSubscribeResponses);

        return GenreSubscriptionPaginationResponse.builder()
            .data(genreSubscribeSlices.getContent())
            .hasNext(genreSubscribeSlices.hasNext())
            .build();
    }

    private BooleanBuilder getWhereClauseInCursorPagination(
        UUID cursor,
        List<UUID> genreIds
    ) {
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.and(getDefaultPredicateInCursorPagination(cursor));

        if (genreIds.isEmpty()) {
            return whereClause;
        }

        return whereClause.and(genre.id.in(genreIds));
    }

    private Predicate getDefaultPredicateInCursorPagination(UUID cursor) {
        BooleanExpression defaultPredicate = genre.isDeleted.isFalse();

        return cursor == null ? defaultPredicate : genre.id.gt(cursor).and(defaultPredicate);
    }
}
