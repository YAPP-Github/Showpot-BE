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
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.request.ArtistFilterDomain;
import org.example.dto.artist.request.ArtistFilterTotalCountDomainRequest;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailDomainResponse;
import org.example.dto.artist.response.ArtistFilterTotalCountDomainResponse;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;
import org.example.dto.artist.response.ArtistPaginationDomainResponse;
import org.example.dto.artist.response.ArtistSimpleDomainResponse;
import org.example.entity.artist.Artist;
import org.example.util.SliceUtil;
import org.example.vo.ArtistSortStandardDomainType;
import org.example.vo.SubscriptionStatus;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistQuerydslRepositoryImpl implements ArtistQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ArtistDetailDomainResponse> findAllWithGenreNames() {
        return createArtistJoinArtistGenreAndGenreQuery()
            .transform(
                groupBy(artist.id).list(
                    Projections.constructor(
                        ArtistDetailDomainResponse.class,
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
    public Optional<ArtistDetailDomainResponse> findArtistWithGenreNamesById(UUID id) {
        return Optional.ofNullable(
            createArtistJoinArtistGenreAndGenreQuery()
                .where(artist.id.eq(id))
                .transform(
                    groupBy(artist.id).as(
                        Projections.constructor(
                            ArtistDetailDomainResponse.class,
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
    public List<ArtistKoreanNameDomainResponse> findAllArtistKoreanName() {
        return jpaQueryFactory
            .select(
                Projections.constructor(
                    ArtistKoreanNameDomainResponse.class,
                    artist.id,
                    artist.koreanName
                )
            )
            .from(artist)
            .where(artist.isDeleted.isFalse())
            .fetch();
    }

    @Override
    public List<Artist> findAllInIds(List<UUID> ids) {
        return jpaQueryFactory
            .selectFrom(artist)
            .where(artist.id.in(ids).and(artist.isDeleted.isFalse()))
            .fetch();
    }

    @Override
    public ArtistPaginationDomainResponse findAllWithCursorPagination(
        ArtistPaginationDomainRequest request
    ) {
        List<ArtistSimpleDomainResponse> result = jpaQueryFactory.select(
                Projections.constructor(
                    ArtistSimpleDomainResponse.class,
                    artist.id,
                    artist.koreanName,
                    artist.englishName,
                    artist.image
                )
            ).from(artist)
            .where(
                getWhereClauseInCursorPagination(
                    request.subscriptionStatus(),
                    request.cursor(),
                    request.artistIds(),
                    request.artistFilterDomain()
                )
            )
            .orderBy(getOrderSpecifier(request.sortStandard()))
            .limit(request.size() + 1)
            .fetch();

        Slice<ArtistSimpleDomainResponse> responses = SliceUtil.makeSlice(
            request.size(),
            result
        );

        return ArtistPaginationDomainResponse.builder()
            .data(responses.getContent())
            .hasNext(responses.hasNext())
            .build();
    }

    @Override
    public Optional<ArtistFilterTotalCountDomainResponse> findFilterArtistTotalCount(
        ArtistFilterTotalCountDomainRequest request
    ) {
        List<UUID> totalCount = jpaQueryFactory
            .selectDistinct(artist.id)
            .from(artist)
            .join(artistGenre).on(isArtistGenreEqualArtistIdAndIsDeletedFalse())
            .join(genre).on(isArtistGenreEqualGenreIdAndIsDeletedFalse())
            .where(getWhereClauseWithFilter(request))
            .fetch();

        return Optional.of(new ArtistFilterTotalCountDomainResponse(totalCount.size()));
    }

    private JPAQuery<?> createArtistJoinArtistGenreAndGenreQuery() {
        return jpaQueryFactory
            .selectFrom(artist)
            .join(artistGenre).on(isArtistGenreEqualArtistIdAndIsDeletedFalse())
            .join(genre).on(isArtistGenreEqualGenreIdAndIsDeletedFalse())
            .where(artist.isDeleted.isFalse());
    }

    private BooleanExpression isArtistGenreEqualArtistIdAndIsDeletedFalse() {
        return artistGenre.artistId.eq(artist.id).and(artistGenre.isDeleted.isFalse());
    }

    private BooleanExpression isArtistGenreEqualGenreIdAndIsDeletedFalse() {
        return artistGenre.genreId.eq(genre.id).and(genre.isDeleted.isFalse());
    }

    private BooleanBuilder getWhereClauseInCursorPagination(
        SubscriptionStatus status,
        UUID cursor,
        List<UUID> artistIds,
        ArtistFilterDomain artistFilterDomain
    ) {
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.and(getDefaultPredicateInCursorPagination(cursor));

        if (status.equals(SubscriptionStatus.SUBSCRIBED)) {
            return whereClause.and(artist.id.in(artistIds));
        }

        if (status.equals(SubscriptionStatus.UNSUBSCRIBED)) {
            addConditionIfNotEmpty(whereClause, artist.id::notIn, artistIds);
            addConditionIfNotEmpty(whereClause, genre.id::in, artistFilterDomain.genreIds());
            addConditionIfNotEmpty(whereClause, artist.artistGender::in, artistFilterDomain.artistGenders());
            addConditionIfNotEmpty(whereClause, artist.artistType::in, artistFilterDomain.artistTypes());
        }

        return whereClause;
    }

    private BooleanBuilder getWhereClauseWithFilter(
        ArtistFilterTotalCountDomainRequest request
    ) {
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.and(artist.isDeleted.isFalse());

        addConditionIfNotEmpty(whereClause, artist.id::notIn, request.artistIds());
        addConditionIfNotEmpty(whereClause, genre.id::in, request.genreIds());
        addConditionIfNotEmpty(whereClause, artist.artistGender::in, request.artistGenders());
        addConditionIfNotEmpty(whereClause, artist.artistType::in, request.artistTypes());

        return whereClause;
    }

    private Predicate getDefaultPredicateInCursorPagination(UUID cursor) {
        BooleanExpression defaultPredicate = artist.isDeleted.isFalse();

        return cursor == null ? defaultPredicate : artist.id.gt(cursor).and(defaultPredicate);
    }

    private <T> void addConditionIfNotEmpty(
        BooleanBuilder whereClause,
        Function<Collection<T>, BooleanExpression> conditionFunction,
        Collection<T> values
    ) {
        if (!values.isEmpty()) {
            whereClause.and(conditionFunction.apply(values));
        }
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
