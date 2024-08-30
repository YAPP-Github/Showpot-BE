package org.example.repository.show.showsearch;

import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowSearch.showSearch;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.request.ShowSearchPaginationDomainRequest;
import org.example.dto.show.response.ShowSearchDomainResponse;
import org.example.dto.show.response.ShowSearchPaginationDomainResponse;
import org.example.util.SliceUtil;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowSearchQuerydslRepositoryImpl implements ShowSearchQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public ShowSearchPaginationDomainResponse searchShow(
        ShowSearchPaginationDomainRequest request
    ) {
        List<ShowSearchDomainResponse> result = jpaQueryFactory.select(
                Projections.constructor(
                    ShowSearchDomainResponse.class,
                    show.id,
                    show.title,
                    show.startDate,
                    show.endDate,
                    show.location,
                    show.image
                )
            )
            .from(showSearch)
            .join(showSearch.show, show)
            .where(showSearch.name.like("%" + request.search() + "%")
                .and(getDefaultPredicateInCursorPagination(request.cursor()))
            )
            .fetch();

        Slice<ShowSearchDomainResponse> showSearchDomainSlices = SliceUtil.makeSlice(
            request.size(),
            result
        );

        return ShowSearchPaginationDomainResponse.builder()
            .data(showSearchDomainSlices.getContent())
            .hasNext(showSearchDomainSlices.hasNext())
            .build();
    }

    private Predicate getDefaultPredicateInCursorPagination(UUID cursor) {
        BooleanExpression defaultPredicate = show.isDeleted.isFalse()
            .and(showSearch.isDeleted.isFalse());

        return cursor == null ? defaultPredicate : show.id.gt(cursor).and(defaultPredicate);
    }
}
