package org.example.port;

import org.example.port.dto.request.ArtistSearchPortRequest;
import org.example.port.dto.response.ArtistSearchPortResponse;
import org.example.vo.ArtistSearchAdapterType;
import org.springframework.stereotype.Component;

@Component
public interface ArtistSearchPort {

    ArtistSearchAdapterType getAdapterType();

    String getAccessToken();

    ArtistSearchPortResponse searchArtist(ArtistSearchPortRequest request);
}
