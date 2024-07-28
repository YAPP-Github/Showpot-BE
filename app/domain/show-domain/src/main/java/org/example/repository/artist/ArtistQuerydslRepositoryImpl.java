package org.example.repository.artist;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static org.example.entity.artist.QArtist.artist;
import static org.example.entity.artist.QArtistGenre.artistGenre;
import static org.example.entity.genre.QGenre.genre;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailPaginationResponse;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.dto.artist.response.SimpleArtistResponse;
import org.example.entity.artist.Artist;
import org.example.querydsl.BooleanStatus;
import org.example.vo.ArtistSortStandardDomainType;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistQuerydslRepositoryImpl implements ArtistQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ArtistDetailResponse> findAllWithGenreNames() {
        return createArtistJoinArtistGenreAndGenreQuery()
            .transform(
                groupBy(artist.id).list(
                    Projections.constructor(
                        ArtistDetailResponse.class,
                        artist.id,
                        artist.koreanName,
                        artist.englishName,
                        artist.image,
                        artist.country,
                        artist.artistGender,
                        artist.artistType,
                        list(genre.name)
                    )
                )
            );
    }

    @Override
    public Optional<ArtistDetailResponse> findArtistWithGenreNamesById(UUID id) {
        return Optional.ofNullable(
            createArtistJoinArtistGenreAndGenreQuery()
                .where(artist.id.eq(id))
                .transform(
                    groupBy(artist.id).as(
                        Projections.constructor(
                            ArtistDetailResponse.class,
                            artist.id,
                            artist.koreanName,
                            artist.englishName,
                            artist.image,
                            artist.country,
                            artist.artistGender,
                            artist.artistType,
                            list(genre.name)
                        )
                    )
                )
                .get(id)
        );
    }

    @Override
    public List<ArtistKoreanNameResponse> findAllArtistKoreanName() {
        return jpaQueryFactory
            .select(
                Projections.constructor(
                    ArtistKoreanNameResponse.class,
                    artist.id,
                    artist.koreanName
                )
            )
            .from(artist)
            .where(BooleanStatus.getArtistIsDeletedFalse())
            .fetch();
    }

    @Override
    public List<Artist> findAllInIds(List<UUID> ids) {
        return jpaQueryFactory
            .selectFrom(artist)
            .where(artist.id.in(ids).and(BooleanStatus.getArtistIsDeletedFalse()))
            .fetch();
    }

    @Override
    public ArtistDetailPaginationResponse findAllWithCursorPagination(ArtistPaginationDomainRequest request) {
        List<SimpleArtistResponse> result = jpaQueryFactory.select(
                Projections.constructor(
                    SimpleArtistResponse.class,
                    artist.id,
                    artist.koreanName,
                    artist.englishName,
                    artist.image
                )
            ).from(artist)
            .where(getWhereClauseInCursorPagination(request.cursor(), request.artistIds()))
            .orderBy(getOrderSpecifier(request.sortStandard()))
            .limit(request.size() + 1)
            .fetch();

        boolean hasNext = result.size() == request.size() + 1;
        return ArtistDetailPaginationResponse.builder()
            .data(hasNext ? result.subList(0, request.size()) : result)
            .hasNext(hasNext)
            .build();
    }

    private JPAQuery<?> createArtistJoinArtistGenreAndGenreQuery() {
        return jpaQueryFactory
            .selectFrom(artist)
            .join(artistGenre).on(isArtistGenreEqualArtistIdAndIsDeletedFalse())
            .join(genre).on(isGenreEqualArtistIdAndIsDeletedFalse())
            .where(BooleanStatus.getArtistIsDeletedFalse());
    }

    private BooleanExpression isArtistGenreEqualArtistIdAndIsDeletedFalse() {
        return artistGenre.artistId.eq(artist.id).and(BooleanStatus.getArtistIsDeletedFalse());
    }

    private BooleanExpression isGenreEqualArtistIdAndIsDeletedFalse() {
        return artistGenre.genreId.eq(genre.id).and(BooleanStatus.getGenreIsDeletedFalse());
    }

    private BooleanBuilder getWhereClauseInCursorPagination(
        UUID cursor,
        List<UUID> artistIds
    ) {
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.and(getDefaultPredicateInCursorPagination(cursor));

        if (artistIds.isEmpty()) {
            return whereClause;
        }

        return whereClause.and(artist.id.in(artistIds));
    }

    private Predicate getDefaultPredicateInCursorPagination(UUID cursor) {
        BooleanExpression defaultPredicate = BooleanStatus.getArtistIsDeletedFalse();

        return cursor == null ? defaultPredicate : artist.id.gt(cursor).and(defaultPredicate);
    }

    private OrderSpecifier<String> getOrderSpecifier(ArtistSortStandardDomainType type) {
        return switch (type) {
            case KOREAN_NAME_ASC -> artist.koreanName.asc();
            case KOREAN_NAME_DESC -> artist.koreanName.desc();
            case ENGLISH_NAME_ASC -> artist.englishName.asc();
            case ENGLISH_NAME_DESC -> artist.englishName.desc();
        };
    }
}
