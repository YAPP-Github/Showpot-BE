package org.example.repository.artist.artistsearch;

import static org.example.entity.artist.QArtist.artist;
import static org.example.entity.artist.QArtistSearch.artistSearch;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.request.ArtistSearchPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailPaginationResponse;
import org.example.dto.artist.response.SimpleArtistResponse;
import org.example.util.SliceUtil;
import org.example.vo.ArtistSortStandardDomainType;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistSearchQuerydslRepositoryImpl implements ArtistSearchQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public ArtistDetailPaginationResponse searchArtist(
        ArtistSearchPaginationDomainRequest request) {
        List<SimpleArtistResponse> result = jpaQueryFactory.select(
                Projections.constructor(
                    SimpleArtistResponse.class,
                    artist.id,
                    artist.koreanName,
                    artist.englishName,
                    artist.image
                )
            )
            .from(artistSearch)
            .join(artistSearch.artist, artist)
            .where(artistSearch.name.like(request.search() + "%")
                .and(getDefaultPredicateInCursorPagination(request.cursor())))
            .orderBy(getOrderSpecifier(request.sortStandard()))
            .fetch();

        Slice<SimpleArtistResponse> simpleArtistSlices = SliceUtil.makeSlice(request.size(),
            result);

        return ArtistDetailPaginationResponse.builder()
            .data(simpleArtistSlices.getContent())
            .hasNext(simpleArtistSlices.hasNext())
            .build();
    }

    private Predicate getDefaultPredicateInCursorPagination(UUID cursor) {
        BooleanExpression defaultPredicate = artist.isDeleted.isFalse();

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
