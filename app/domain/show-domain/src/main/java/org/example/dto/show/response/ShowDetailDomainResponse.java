package org.example.dto.show.response;

import java.util.Set;
import org.example.dto.artist.response.ArtistDomainResponse;
import org.example.dto.genre.response.GenreDomainResponse;

public record ShowDetailDomainResponse(
    ShowDomainResponse show,
    Set<ArtistDomainResponse> artists,
    Set<GenreDomainResponse> genres,
    Set<ShowTicketingTimeDomainResponse> ticketingTimes
) {

}
