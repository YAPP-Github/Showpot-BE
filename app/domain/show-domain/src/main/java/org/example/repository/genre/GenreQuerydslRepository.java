package org.example.repository.genre;

import java.util.List;
import java.util.UUID;
import org.example.dto.genre.request.GenreSubscriptionPaginationDomainRequest;
import org.example.dto.genre.response.GenreSubscriptionPaginationDomainResponse;
import org.example.entity.genre.Genre;

public interface GenreQuerydslRepository {

    List<Genre> findAllInId(List<UUID> ids);

    GenreSubscriptionPaginationDomainResponse findAllWithCursorPagination(
        GenreSubscriptionPaginationDomainRequest request);
}
