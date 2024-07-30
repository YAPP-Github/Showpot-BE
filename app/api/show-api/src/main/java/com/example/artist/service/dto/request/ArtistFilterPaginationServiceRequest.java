package com.example.artist.service.dto.request;

import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.dto.artist.request.ArtistFilterPaginationDomainRequest;

@Builder
public record ArtistFilterPaginationServiceRequest(
    List<ArtistGenderApiType> artistGenderApiTypes,
    List<ArtistApiType> artistApiTypes,
    List<UUID> genreIds,
    UUID userId,
    UUID cursor,
    int size
) {

    public ArtistFilterPaginationDomainRequest toDomainRequest(List<UUID> artistIds) {
        var artistGenders = artistGenderApiTypes.stream()
            .map(ArtistGenderApiType::toDomainType)
            .toList();
        var artistTypes = artistApiTypes.stream()
            .map(ArtistApiType::toDomainType)
            .toList();

        return ArtistFilterPaginationDomainRequest.builder()
            .artistGenders(artistGenders)
            .artistTypes(artistTypes)
            .genreIds(genreIds)
            .artistIds(artistIds)
            .cursor(cursor)
            .size(size)
            .build();
    }

}
