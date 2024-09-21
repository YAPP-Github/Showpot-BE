package org.example.fixture.port;

import org.example.port.ArtistSearchPort;
import org.example.port.dto.request.ArtistSearchPortRequest;
import org.example.port.dto.response.ArtistSearchPortResponse;
import org.example.vo.ArtistSearchAdapterType;
import org.springframework.stereotype.Component;

@Component
public class ArtistSearchPortFixture implements ArtistSearchPort {

    @Override
    public ArtistSearchAdapterType getAdapterType() {
        return null;
    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public ArtistSearchPortResponse searchArtist(ArtistSearchPortRequest request) {
        return null;
    }
}
