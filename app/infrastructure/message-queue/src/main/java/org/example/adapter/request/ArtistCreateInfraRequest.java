package org.example.adapter.request;

import java.util.List;
import org.example.port.dto.request.ArtistCreatePortRequest;

public record ArtistCreateInfraRequest(
    List<ArtistDomainInfraRequest> request
) {

    public static ArtistCreateInfraRequest from(ArtistCreatePortRequest request) {
        return new ArtistCreateInfraRequest(
            request.artists().stream().map(ArtistDomainInfraRequest::from).toList()
        );
    }

}
