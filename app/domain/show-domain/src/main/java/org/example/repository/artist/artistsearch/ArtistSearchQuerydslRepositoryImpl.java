package org.example.repository.artist.artistsearch;

import static org.example.entity.artist.QArtist.artist;
import static org.example.entity.artist.QArtistSearch.artistSearch;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistSearchResponse;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistSearchQuerydslRepositoryImpl implements ArtistSearchQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Optional<ArtistSearchResponse> searchArtist(String name) {
        return Optional.ofNullable(
            jpaQueryFactory.select(
                    Projections.constructor(
                        ArtistSearchResponse.class,
                        artist.id,
                        artist.koreanName,
                        artist.englishName,
                        artist.image
                    )
                )
                .from(artistSearch)
                .join(artistSearch.artist, artist)
                .where(artistSearch.name.like(name + "%").and(artistSearch.isDeleted.isFalse()))
                .where(artist.isDeleted.isFalse())
                .fetchFirst()
        );
    }
}
