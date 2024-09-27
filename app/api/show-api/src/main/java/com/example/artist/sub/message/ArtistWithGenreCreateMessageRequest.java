package com.example.artist.sub.message;

import com.example.artist.service.dto.request.ArtistWithGenreCreateServiceRequest;
import java.util.List;

public record ArtistWithGenreCreateMessageRequest(
    List<ArtistGenreMessageRequest> request
) {

    public ArtistWithGenreCreateServiceRequest toServiceRequest() {
        return new ArtistWithGenreCreateServiceRequest(
            request.stream().map(ArtistGenreMessageRequest::toServiceRequest).toList()
        );
    }

}
