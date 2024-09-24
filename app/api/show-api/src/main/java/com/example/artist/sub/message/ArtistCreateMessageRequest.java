package com.example.artist.sub.message;

import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import java.util.List;

public record ArtistCreateMessageRequest(
    List<ArtistGenreMessageRequest> request
) {

    public ArtistCreateServiceRequest toServiceRequest() {
        return new ArtistCreateServiceRequest(
            request.stream().map(ArtistGenreMessageRequest::toServiceRequest).toList()
        );
    }

}
