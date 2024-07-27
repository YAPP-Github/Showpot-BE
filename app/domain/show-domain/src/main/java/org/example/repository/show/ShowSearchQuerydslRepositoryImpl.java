package org.example.repository.show;

import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowSearch.showSearch;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.ShowSearchDomainResponse;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowSearchQuerydslRepositoryImpl implements ShowSearchQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<ShowSearchDomainResponse> searchShow(String name) {
        return Optional.ofNullable(
            jpaQueryFactory.select(
                    Projections.constructor(
                        ShowSearchDomainResponse.class,
                        show.id,
                        show.title,
                        show.date,
                        show.location,
                        show.image
                    )
                )
                .from(showSearch)
                .join(showSearch.show, show)
                .where(showSearch.name.like(name + "%").and(showSearch.isDeleted.isFalse()))
                .where(show.isDeleted.isFalse())
                .fetchFirst()
        );
    }
}
