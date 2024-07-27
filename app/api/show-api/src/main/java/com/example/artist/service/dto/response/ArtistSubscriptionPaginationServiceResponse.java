package com.example.artist.service.dto.response;

import com.example.artist.service.dto.param.ArtistSubscriptionPaginationServiceParam;
import java.util.List;
import lombok.Builder;

@Builder
public record ArtistSubscriptionPaginationServiceResponse(
    boolean hasNext,
    List<ArtistSubscriptionPaginationServiceParam> data
) {

}
