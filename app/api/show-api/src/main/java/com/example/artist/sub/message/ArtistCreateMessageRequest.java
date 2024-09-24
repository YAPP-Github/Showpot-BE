package com.example.artist.sub.message;

import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import java.util.List;

public record ArtistCreateMessageRequest(
    List<ArtistDomainMessageRequest> request
) {

    public ArtistCreateServiceRequest toServiceRequest() {
        return new ArtistCreateServiceRequest(
            request.stream().map(ArtistDomainMessageRequest::toServiceRequest).toList()
        );
    }

}
