package org.example.repository.show;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.querydsl.core.group.GroupBy.set;
import static org.example.entity.artist.QArtist.artist;
import static org.example.entity.genre.QGenre.genre;
import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowArtist.showArtist;
import static org.example.entity.show.QShowGenre.showGenre;
import static org.example.entity.show.QShowTicketingTime.showTicketingTime;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.OrderSpecifier.NullHandling;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDomainResponse;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;
import org.example.dto.genre.response.GenreDomainResponse;
import org.example.dto.genre.response.GenreNameDomainResponse;
import org.example.dto.show.request.ShowPaginationDomainRequest;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.dto.show.response.ShowDomainResponse;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.dto.show.response.ShowPaginationDomainResponse;
import org.example.dto.show.response.ShowTicketingTimeDomainResponse;
import org.example.dto.show.response.ShowWithTicketingTimesDomainResponse;
import org.example.entity.show.Show;
import org.example.util.DateTimeUtil;
import org.example.util.SliceUtil;
import org.example.vo.ShowSortType;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowQuerydslRepositoryImpl implements ShowQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<ShowDetailDomainResponse> findShowDetailById(UUID id) {
        return Optional.ofNullable(
            createShowJoinArtistAndGenreQuery()
                .where(show.id.eq(id))
                .transform(
                    groupBy(show.id).as(getShowDetailConstructor())
                )
                .get(id)
        );
    }

    @Override
    public List<ShowWithTicketingTimesDomainResponse> findShowDetailWithTicketingTimes() {
        return jpaQueryFactory.selectFrom(show)
            .join(showTicketingTime).on(isShowTicketingEqualShowAndIsDeletedFalse())
            .where(show.isDeleted.isFalse())
            .transform(
                groupBy(show.id).list(
                    Projections.constructor(
                        ShowWithTicketingTimesDomainResponse.class,
                        Projections.constructor(
                            ShowDomainResponse.class,
                            show.id,
                            show.title,
                            show.content,
                            show.startDate,
                            show.endDate,
                            show.location,
                            show.image,
                            show.lastTicketingAt,
                            show.seatPrices,
                            show.ticketingSites
                        ),
                        list(
                            Projections.constructor(
                                ShowTicketingTimeDomainResponse.class,
                                showTicketingTime.ticketingType,
                                showTicketingTime.ticketingAt
                            )
                        )
                    )
                )
            );
    }

    @Override
    public Optional<ShowInfoDomainResponse> findShowInfoById(UUID id) {
        return Optional.ofNullable(
            createShowJoinArtistAndGenreQuery()
                .where(show.id.eq(id))
                .transform(
                    groupBy(show.id).as(getShowInfoConstructor())
                )
                .get(id)
        );
    }

    @Override
    public ShowPaginationDomainResponse findShows(ShowPaginationDomainRequest request) {
        List<ShowDetailDomainResponse> result;
        switch (request.sort()) {
            case POPULAR -> result = jpaQueryFactory
                .selectFrom(show)
                .join(showArtist).on(isShowArtistEqualShowIdAndIsDeletedFalse())
                .join(artist).on(isArtistIdEqualShowArtistAndIsDeletedFalse())
                .join(showGenre).on(isShowGenreEqualShowIdAndIsDeletedFalse())
                .join(genre).on(isGenreIdEqualShowGenreAndIsDeletedFalse())
                .join(showTicketingTime)
                .on(showTicketingTime.show.id.eq(show.id).and(showTicketingTime.isDeleted.isFalse()))
                .where(getShowPaginationWhereCondition(request))
                .limit(request.size() + 1)
                .orderBy(getShowOrderSpecifier(request.sort()).toArray(OrderSpecifier[]::new))
                .transform(
                    groupBy(show.id).as(getShowDetailConstructor())
                ).values().stream()
                .toList();
            default -> result = findShowsByRecent(request);
        }

        Slice<ShowDetailDomainResponse> slice = SliceUtil.makeSlice(request.size(), result);

        return ShowPaginationDomainResponse.builder()
            .data(slice.getContent())
            .hasNext(slice.hasNext())
            .build();
    }

    private List<ShowDetailDomainResponse> findShowsByRecent(ShowPaginationDomainRequest request) {
        JPAQuery<LocalDateTime> closestTicketingTimeQuery = jpaQueryFactory
            .select(showTicketingTime.ticketingAt.min())
            .from(showTicketingTime)
            .where(showTicketingTime.show.id.eq(show.id)
                .and(showTicketingTime.ticketingAt.gt(request.now())));

        BooleanExpression whereExpression = show.isDeleted.isFalse()
            .and(closestTicketingTimeQuery.isNotNull());

        if (request.cursorId() != null) {
            whereExpression.and(
                closestTicketingTimeQuery.gt(DateTimeUtil.parse(request.cursorValue().toString()))
                    .or(closestTicketingTimeQuery.eq(DateTimeUtil.parse(request.cursorValue().toString()))
                        .and(show.id.gt(request.cursorId()))
                    )
            );
        }

        List<ShowDetailDomainResponse> response = jpaQueryFactory
            .selectFrom(show)
            .leftJoin(showGenre).on(show.id.eq(showGenre.showId).and(showGenre.isDeleted.isFalse()))
            .leftJoin(genre).on(showGenre.genreId.eq(genre.id).and(genre.isDeleted.isFalse()))
            .leftJoin(showArtist).on(show.id.eq(showArtist.showId))
            .leftJoin(artist).on(showArtist.artistId.eq(artist.id))
            .leftJoin(showTicketingTime).on(show.id.eq(showTicketingTime.show.id))
            .where(whereExpression)
            .orderBy(
                new OrderSpecifier<>(Order.ASC, closestTicketingTimeQuery, NullHandling.NullsLast),
                new OrderSpecifier<>(Order.ASC, show.id)
            )
            .transform(
                groupBy(show.id).as(getShowDetailConstructor())
            ).values().stream().toList();

        return response;
    }

    private ConstructorExpression<ShowDetailDomainResponse> getShowDetailConstructor() {
        return Projections.constructor(
            ShowDetailDomainResponse.class,
            Projections.constructor(
                ShowDomainResponse.class,
                show.id,
                show.title,
                show.content,
                show.startDate,
                show.endDate,
                show.location,
                show.image,
                show.lastTicketingAt,
                show.seatPrices,
                show.ticketingSites
            ),
            set(
                Projections.constructor(
                    ArtistDomainResponse.class,
                    artist.id,
                    artist.koreanName,
                    artist.englishName,
                    artist.image,
                    artist.country,
                    artist.artistGender,
                    artist.artistType
                )
            ),
            set(
                Projections.constructor(
                    GenreDomainResponse.class,
                    genre.id,
                    genre.name
                )
            ),
            set(
                Projections.constructor(
                    ShowTicketingTimeDomainResponse.class,
                    showTicketingTime.ticketingType,
                    showTicketingTime.ticketingAt
                )
            )
        );
    }

    private ConstructorExpression<ShowInfoDomainResponse> getShowInfoConstructor() {
        return Projections.constructor(
            ShowInfoDomainResponse.class,
            Projections.constructor(
                ShowDomainResponse.class,
                show.id,
                show.title,
                show.content,
                show.startDate,
                show.endDate,
                show.location,
                show.image,
                show.lastTicketingAt,
                show.seatPrices,
                show.ticketingSites
            ),
            set(
                Projections.constructor(
                    ArtistKoreanNameDomainResponse.class,
                    artist.id,
                    artist.koreanName
                )
            ),
            set(
                Projections.constructor(
                    GenreNameDomainResponse.class,
                    genre.id,
                    genre.name
                )
            ),
            set(
                Projections.constructor(
                    ShowTicketingTimeDomainResponse.class,
                    showTicketingTime.ticketingType,
                    showTicketingTime.ticketingAt
                )
            )
        );
    }

    private JPAQuery<Show> createShowJoinArtistAndGenreQuery() {
        return jpaQueryFactory
            .selectFrom(show)
            .join(showArtist).on(isShowArtistEqualShowIdAndIsDeletedFalse())
            .join(artist).on(isArtistIdEqualShowArtistAndIsDeletedFalse())
            .join(showGenre).on(isShowGenreEqualShowIdAndIsDeletedFalse())
            .join(genre).on(isGenreIdEqualShowGenreAndIsDeletedFalse())
            .join(showTicketingTime).on(isShowTicketingEqualShowAndIsDeletedFalse())
            .where(show.isDeleted.isFalse());
    }

    private BooleanExpression isShowArtistEqualShowIdAndIsDeletedFalse() {
        return showArtist.showId.eq(show.id).and(showArtist.isDeleted.isFalse());
    }

    private BooleanExpression isArtistIdEqualShowArtistAndIsDeletedFalse() {
        return artist.id.eq(showArtist.artistId).and(artist.isDeleted.isFalse());
    }

    private BooleanExpression isShowGenreEqualShowIdAndIsDeletedFalse() {
        return showGenre.showId.eq(show.id).and(showGenre.isDeleted.isFalse());
    }

    private BooleanExpression isGenreIdEqualShowGenreAndIsDeletedFalse() {
        return genre.id.eq(showGenre.genreId).and(genre.isDeleted.isFalse());
    }

    private BooleanExpression isShowTicketingEqualShowAndIsDeletedFalse() {
        return showTicketingTime.show.id.eq(show.id).and(showTicketingTime.isDeleted.isFalse());
    }

    private BooleanExpression getShowPaginationWhereCondition(ShowPaginationDomainRequest request) {
        BooleanExpression defaultCondition = show.isDeleted.isFalse();

        switch (request.sort()) {
            case POPULAR -> defaultCondition.and(show.viewCount.gt(0));
            default -> defaultCondition.and(show.lastTicketingAt.after(request.now()));
        }

        if (request.cursorId() != null) {
            defaultCondition.and(show.id.gt(request.cursorId()));
        }

        // 티켓팅 오픈 예정 스케줄이 있는 경우
        // TODO: 이름 변경이 필요해 보임
        if (request.onlyOpenSchedule()) {
            defaultCondition.and(show.lastTicketingAt.after(request.now()));
        }

        return defaultCondition;
    }

    // TODO: Show 조회수 컬럼 추가 후 수정
    private List<OrderSpecifier> getShowOrderSpecifier(ShowSortType sortType) {
        return switch (sortType) {
            case RECENT -> List.of(show.lastTicketingAt.asc(), show.id.asc());
            case POPULAR -> List.of(show.viewCount.desc(), show.id.asc());
        };
    }
}
