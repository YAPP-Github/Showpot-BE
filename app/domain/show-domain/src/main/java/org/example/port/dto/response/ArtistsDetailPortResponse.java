package org.example.port.dto.response;

import java.util.List;
import org.example.port.dto.param.ArtistSearchPortParam;

public record ArtistsDetailPortResponse(
    List<ArtistSearchPortParam> artists
) {

}
