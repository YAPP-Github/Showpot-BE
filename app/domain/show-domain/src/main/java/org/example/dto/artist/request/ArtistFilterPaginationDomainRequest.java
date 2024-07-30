package org.example.dto.artist.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.vo.ArtistGender;
import org.example.vo.ArtistType;

@Builder
public record ArtistFilterPaginationDomainRequest(
    List<ArtistGender> artistGenders,
    List<ArtistType> artistTypes,
    List<UUID> genreIds,
    List<UUID> artistIds,
    UUID cursor,
    int size
) {

}
