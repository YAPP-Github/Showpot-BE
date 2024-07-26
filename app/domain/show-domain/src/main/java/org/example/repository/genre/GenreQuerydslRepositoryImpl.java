package org.example.repository.genre;

import static org.example.entity.genre.QGenre.genre;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.genre.Genre;
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
}
