package org.example.repository.genre;

import java.util.List;
import java.util.UUID;
import org.example.dto.genre.request.GenreSubscriptionPaginationRequest;
import org.example.dto.genre.response.GenreSubscriptionPaginationResponse;
import org.example.entity.genre.Genre;

public interface GenreQuerydslRepository {

    List<Genre> findAllInId(List<UUID> ids);

    GenreSubscriptionPaginationResponse findAllWithCursorPagination(
        GenreSubscriptionPaginationRequest request);
}
