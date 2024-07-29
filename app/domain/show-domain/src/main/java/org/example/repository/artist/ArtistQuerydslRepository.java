package org.example.repository.artist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.dto.artist.request.ArtistSubscriptionPaginationDomainRequest;
import org.example.dto.artist.request.ArtistUnsubscriptionPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.dto.artist.response.ArtistKoreanNameResponse;
import org.example.dto.artist.response.ArtistSubscriptionPaginationDomainResponse;
import org.example.dto.artist.response.ArtistUnsubscriptionPaginationDomainResponse;
import org.example.entity.artist.Artist;

public interface ArtistQuerydslRepository {

    List<ArtistDetailResponse> findAllWithGenreNames();

    Optional<ArtistDetailResponse> findArtistWithGenreNamesById(UUID id);

    List<ArtistKoreanNameResponse> findAllArtistKoreanName();

    List<Artist> findAllInIds(List<UUID> ids);

    ArtistSubscriptionPaginationDomainResponse findAllWithCursorPagination(
        ArtistSubscriptionPaginationDomainRequest request
    );

    ArtistUnsubscriptionPaginationDomainResponse findAllWithCursorPagination(
        ArtistUnsubscriptionPaginationDomainRequest request
    );
}
