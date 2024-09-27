package org.example.fixture.port;

import org.example.port.ArtistCreatePort;
import org.example.port.dto.request.ArtistCreatePortRequest;
import org.springframework.stereotype.Component;

@Component
public class ArtistCreatePortFixture implements ArtistCreatePort {

    @Override
    public void createArtist(String topic, ArtistCreatePortRequest request) {

    }
}
