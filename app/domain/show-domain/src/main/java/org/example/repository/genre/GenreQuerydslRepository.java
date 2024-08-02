package org.example.repository.genre;

import java.util.List;
import java.util.UUID;
import org.example.dto.genre.request.GenrePaginationDomainRequest;
import org.example.dto.genre.response.GenrePaginationDomainResponse;
import org.example.entity.genre.Genre;

public interface GenreQuerydslRepository {

    List<Genre> findAllInId(List<UUID> ids);

    GenrePaginationDomainResponse findAllWithCursorPagination(
        GenrePaginationDomainRequest request
    );
}
