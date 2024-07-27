package org.example.dto.response;

import java.util.List;

public record PaginationServiceResponse<T>(
    boolean hasNext,
    List<T> data
) {

    public static <T> PaginationServiceResponse<T> of(
        List<T> data,
        boolean hasNext
    ) {
        if (data == null || data.isEmpty()) {
            data = List.of();
        }

        return new PaginationServiceResponse<>(hasNext, data);
    }
}
