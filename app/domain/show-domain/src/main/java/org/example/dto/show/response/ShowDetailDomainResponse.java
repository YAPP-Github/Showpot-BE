package org.example.dto.show.response;

import java.util.Set;
import lombok.Builder;
import org.example.dto.artist.response.ArtistDomainResponse;
import org.example.dto.genre.response.GenreDomainResponse;

@Builder
public record ShowDetailDomainResponse(
    ShowDomainResponse show,
    Set<ArtistDomainResponse> artists,
    Set<GenreDomainResponse> genres,
    Set<ShowTicketingTimeDomainResponse> showTicketingTimes
) {

}
