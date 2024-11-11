package org.example.dto.response;

import java.util.List;

public record PaginationServiceResponse<T>(
    boolean hasNext,
    List<T> data,
    CursorApiResponse cursor
) {

    public static <T> PaginationServiceResponse<T> of(
        List<T> data,
        boolean hasNext
    ) {
        if (data == null || data.isEmpty()) {
            data = List.of();
        }

        return new PaginationServiceResponse<>(hasNext, data, CursorApiResponse.noneCursor());
    }

    public static <T> PaginationServiceResponse<T> of(
        List<T> data,
        boolean hasNext,
        CursorApiResponse cursor
    ) {
        if (data == null || data.isEmpty()) {
            data = List.of();
        }

        return new PaginationServiceResponse<>(hasNext, data, cursor);
    }
}
