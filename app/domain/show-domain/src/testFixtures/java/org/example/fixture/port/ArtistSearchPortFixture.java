package org.example.fixture.port;

import java.util.List;
import org.example.port.ArtistSearchPort;
import org.example.port.dto.param.ArtistSearchPortParam;
import org.example.port.dto.request.ArtistSearchPortRequest;
import org.example.port.dto.request.FindArtistsPortRequest;
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

    @Override
    public List<ArtistSearchPortParam> findArtistsBySpotifyArtistId(
        FindArtistsPortRequest request
    ) {
        return null;
    }
}
