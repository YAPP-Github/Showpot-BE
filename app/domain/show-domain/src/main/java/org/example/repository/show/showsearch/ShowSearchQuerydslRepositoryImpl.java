package org.example.repository.show.showsearch;

import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowSearch.showSearch;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.ShowSearchResponse;
import org.example.querydsl.BooleanStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowSearchQuerydslRepositoryImpl implements ShowSearchQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<ShowSearchResponse> searchShow(String name) {
        return Optional.ofNullable(
            jpaQueryFactory.select(
                    Projections.constructor(
                        ShowSearchResponse.class,
                        show.id,
                        show.title,
                        show.date,
                        show.location,
                        show.image
                    )
                )
                .from(showSearch)
                .join(showSearch.show, show)
                .where(showSearch.name.like(name + "%")
                    .and(BooleanStatus.getShowSearchIsDeletedFalse()))
                .where(show.isDeleted.isFalse())
                .fetchFirst()
        );
    }
}
