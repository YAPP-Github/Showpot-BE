package org.example.repository.show.showgenre;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static org.example.entity.genre.QGenre.genre;
import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowGenre.showGenre;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.dto.genre.response.GenreNameDomainResponse;
import org.example.dto.genre.response.GenreNamesWithShowIdDomainResponse;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowGenreQuerydslRepositoryImpl implements ShowGenreQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<GenreNamesWithShowIdDomainResponse> findGenreNamesWithShowId() {
        return jpaQueryFactory.selectFrom(showGenre)
            .join(show).on(show.id.eq(showGenre.showId), show.isDeleted.isFalse())
            .join(genre).on(genre.id.eq(showGenre.genreId), genre.isDeleted.isFalse())
            .where(showGenre.isDeleted.isFalse())
            .transform(
                groupBy(showGenre.id).list(
                    Projections.constructor(
                        GenreNamesWithShowIdDomainResponse.class,
                        show.id,
                        list(
                            Projections.constructor(
                                GenreNameDomainResponse.class,
                                genre.id,
                                genre.name
                            )
                        )
                    )
                )
            );
    }
}
