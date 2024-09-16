package org.example.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

public record CursorApiResponse(

    @Schema(description = "조회한 데이터의 Cursor Id")
    UUID id,

    @Schema(description = "조회한 데이터의 Cursor Value")
    Object value
) {
    public static CursorApiResponse toCursorResponse(UUID id, Object value) {
        return new CursorApiResponse(id, value);
    }

    public static CursorApiResponse toCursorId(UUID id) {
        return new CursorApiResponse(id, "");
    }

}
