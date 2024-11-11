package org.example.service.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Builder;
import org.example.dto.response.CursorApiResponse;
import org.example.entity.show.Show;

public record NotificationServiceResponse(
    int size,
    boolean hasNext,
    List<NotificationInfoWithImageResponse> data,
    CursorApiResponse cursor
) {

    @Builder
    public record NotificationInfoWithImageResponse(
        UUID id,
        UUID showId,
        String title,
        String content,
        LocalDateTime createAt,
        String imageURL
    ) {


    }

    public static NotificationServiceResponse of(
        NotificationPaginationResponse response,
        List<Show> shows
    ) {
        Map<UUID, String> showIdToImageUrlMap = shows.stream()
            .collect(Collectors.toMap(Show::getId, Show::getImage));

        List<NotificationInfoWithImageResponse> updatedData = response.data().stream()
            .map(info -> NotificationInfoWithImageResponse.builder()
                .id(info.id())
                .showId(info.showId())
                .title(info.title())
                .content(info.content())
                .createAt(info.createAt())
                .imageURL(showIdToImageUrlMap.get(info.showId()))
                .build()
            )
            .toList();

        return new NotificationServiceResponse(
            response.size(),
            response.hasNext(),
            updatedData,
            response.cursor()
        );

    }

    public static NotificationServiceResponse noneData() {
        return new NotificationServiceResponse(0, false, List.of(), CursorApiResponse.noneCursor());
    }

}
