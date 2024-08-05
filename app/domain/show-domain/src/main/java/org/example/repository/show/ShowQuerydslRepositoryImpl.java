package org.example.repository.show;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.set;
import static org.example.entity.artist.QArtist.artist;
import static org.example.entity.genre.QGenre.genre;
import static org.example.entity.show.QShow.show;
import static org.example.entity.show.QShowArtist.showArtist;
import static org.example.entity.show.QShowGenre.showGenre;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDomainResponse;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;
import org.example.dto.genre.response.GenreDomainResponse;
import org.example.dto.genre.response.GenreNameDomainResponse;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.dto.show.response.ShowDomainResponse;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.entity.show.Show;
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
                    groupBy(show.id).as(
                        Projections.constructor(
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
                            )
                        )
                    )
                )
                .get(id)
        );
    }

    @Override
    public List<ShowInfoDomainResponse> findAllShowInfos() {
        return createShowJoinArtistAndGenreQuery()
            .transform(
                groupBy(show.id).list(
                    Projections.constructor(
                        ShowInfoDomainResponse.class,
                        show.id,
                        show.title,
                        show.content,
                        show.startDate,
                        show.endDate,
                        show.location,
                        show.image,
                        show.seatPrices,
                        show.ticketingSites,
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
                    groupBy(show.id).as(
                        Projections.constructor(
                            ShowInfoDomainResponse.class,
                            show.id,
                            show.title,
                            show.content,
                            show.startDate,
                            show.endDate,
                            show.location,
                            show.image,
                            show.seatPrices,
                            show.ticketingSites,
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
                            )
                        )
                    )
                )
                .get(id)
        );
    }

    private JPAQuery<Show> createShowJoinArtistAndGenreQuery() {
        return jpaQueryFactory
            .selectFrom(show)
            .join(showArtist).on(isShowArtistEqualShowIdAndIsDeletedFalse())
            .join(artist).on(isArtistIdEqualShowArtistAndIsDeletedFalse())
            .join(showGenre).on(isShowGenreEqualShowIdAndIsDeletedFalse())
            .join(genre).on(isGenreIdEqualShowGenreAndIsDeletedFalse())
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

}
