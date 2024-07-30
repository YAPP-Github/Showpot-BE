package org.example.repository.artist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.dto.artist.request.ArtistFilterPaginationDomainRequest;
import org.example.dto.artist.request.ArtistFilterTotalCountDomainRequest;
import org.example.dto.artist.request.ArtistSubscriptionPaginationDomainRequest;
import org.example.dto.artist.request.ArtistUnsubscriptionPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailDomainResponse;
import org.example.dto.artist.response.ArtistFilterPaginationDomainResponse;
import org.example.dto.artist.response.ArtistFilterTotalCountDomainResponse;
import org.example.dto.artist.response.ArtistKoreanNameDomainResponse;
import org.example.dto.artist.response.ArtistSubscriptionPaginationDomainResponse;
import org.example.dto.artist.response.ArtistUnsubscriptionPaginationDomainResponse;
import org.example.entity.artist.Artist;

public interface ArtistQuerydslRepository {

    List<ArtistDetailDomainResponse> findAllWithGenreNames();

    Optional<ArtistDetailDomainResponse> findArtistWithGenreNamesById(UUID id);

    List<ArtistKoreanNameDomainResponse> findAllArtistKoreanName();

    List<Artist> findAllInIds(List<UUID> ids);

    ArtistSubscriptionPaginationDomainResponse findAllWithCursorPagination(
        ArtistSubscriptionPaginationDomainRequest request
    );

    ArtistUnsubscriptionPaginationDomainResponse findAllWithCursorPagination(
        ArtistUnsubscriptionPaginationDomainRequest request
    );

    ArtistFilterPaginationDomainResponse findAllWithCursorPagination(
        ArtistFilterPaginationDomainRequest request
    );

    Optional<ArtistFilterTotalCountDomainResponse> findFilterArtistTotalCount(
        ArtistFilterTotalCountDomainRequest request
    );
}
