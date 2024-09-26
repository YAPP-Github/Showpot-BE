package org.example.message;

import java.util.List;
import org.example.port.dto.request.ArtistCreatePortRequest;

public record ArtistWithGenreCreateInfraMessage(
    List<ArtistGenreDomainInfraMessage> request
) {

    public static ArtistWithGenreCreateInfraMessage from(ArtistCreatePortRequest request) {
        return new ArtistWithGenreCreateInfraMessage(
            request.artists().stream().map(ArtistGenreDomainInfraMessage::from).toList()
        );
    }

}
