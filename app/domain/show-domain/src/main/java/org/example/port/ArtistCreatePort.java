package org.example.port;

import org.example.port.dto.request.ArtistCreatePortRequest;

public interface ArtistCreatePort {

    void createArtist(String topic, ArtistCreatePortRequest request);

}
