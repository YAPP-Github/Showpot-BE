package com.example.show.controller.dto.response;

import com.example.show.service.dto.response.ShowArtistSimpleServiceResponse;
import java.util.UUID;
import lombok.Builder;

@Builder
public record ShowArtistPaginationApiParam(
    UUID id,
    String koreanName,
    String englishName,
    String image
) {

    public static ShowArtistPaginationApiParam from(ShowArtistSimpleServiceResponse response) {
        return ShowArtistPaginationApiParam.builder()
            .id(response.id())
            .koreanName(response.koreanName())
            .englishName(response.englishName())
            .image(response.image())
            .build();
    }
}
