package org.example.repository.show;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
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
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.dto.artist.response.GenreNameResponse;
import org.example.dto.artist.response.ShowInfoResponse;
import org.example.entity.show.Show;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowQuerydslRepositoryImpl implements ShowQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ShowInfoResponse> findAllShowInfos() {
        return createShowJoinArtistAndGenreQuery()
            .transform(
                groupBy(show.id).list(
                    Projections.constructor(
                        ShowInfoResponse.class,
                        show.id,
                        show.title,
                        show.content,
                        show.date,
                        show.location,
                        show.image,
                        show.seatPrice,
                        show.ticketing,
                        list(
                            Projections.constructor(
                                ArtistKoreanNameResponse.class,
                                artist.id,
                                artist.koreanName
                            )
                        ),
                        list(
                            Projections.constructor(
                                GenreNameResponse.class,
                                genre.id,
                                genre.name
                            )
                        )
                    )
                )
            );
    }

    @Override
    public Optional<ShowInfoResponse> findShowInfoById(UUID id) {
        return Optional.ofNullable(
            createShowJoinArtistAndGenreQuery()
                .where(show.id.eq(id))
                .transform(
                    groupBy(show.id).as(
                        Projections.constructor(
                            ShowInfoResponse.class,
                            show.id,
                            show.title,
                            show.content,
                            show.date,
                            show.location,
                            show.image,
                            show.seatPrice,
                            show.ticketing,
                            list(
                                Projections.constructor(
                                    ArtistKoreanNameResponse.class,
                                    artist.id,
                                    artist.koreanName
                                )
                            ),
                            list(
                                Projections.constructor(
                                    GenreNameResponse.class,
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
