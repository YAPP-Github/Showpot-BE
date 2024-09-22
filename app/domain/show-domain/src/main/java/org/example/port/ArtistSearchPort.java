package org.example.port;

import java.util.List;
import org.example.port.dto.param.ArtistSearchPortParam;
import org.example.port.dto.request.ArtistSearchPortRequest;
import org.example.port.dto.request.FindArtistsPortRequest;
import org.example.port.dto.response.ArtistSearchPortResponse;
import org.example.vo.ArtistSearchAdapterType;
import org.springframework.stereotype.Component;

@Component
public interface ArtistSearchPort {

    ArtistSearchAdapterType getAdapterType();

    String getAccessToken();

    ArtistSearchPortResponse searchArtist(ArtistSearchPortRequest request);

    List<ArtistSearchPortParam> findArtistsBySpotifyArtistId(FindArtistsPortRequest request);
}
