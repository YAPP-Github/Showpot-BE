package org.example.repository.artist;

import java.util.List;
import java.util.UUID;
import org.example.dto.artist.request.ArtistPaginationDomainRequest;
import org.example.dto.artist.response.ArtistDetailDomainResponse;
import org.example.dto.artist.response.ArtistNameDomainResponse;
import org.example.dto.artist.response.ArtistPaginationDomainResponse;
import org.example.entity.artist.Artist;

public interface ArtistQuerydslRepository {

    List<ArtistDetailDomainResponse> findAllWithGenreNames();

    List<ArtistNameDomainResponse> findAllArtistName();

    List<Artist> findAllInIds(List<UUID> ids);

    ArtistPaginationDomainResponse findAllWithCursorPagination(
        ArtistPaginationDomainRequest request
    );
}
